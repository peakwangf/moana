package com.peakwang.dao;

import java.util.List;
import java.util.Map;

import javax.jdo.*;
import java.lang.reflect.Field;

import org.datanucleus.api.jdo.JDOQuery;
import org.datanucleus.metadata.StoredProcQueryParameterMode;
import org.datanucleus.store.rdbms.query.StoredProcedureQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.peakwang.dao.BasicDao;

@Repository
public class BasicDaoImpl implements BasicDao{
	
   
	@Autowired
    private PersistenceManagerFactory persistenceManagerFactory;
	
	@Override
	public <T> List<T> selectByQuery(Class<T> classtype,String params){
		 PersistenceManager pm = persistenceManagerFactory.getPersistenceManager();
	     List<T> list = null;
	     Query q = pm.newQuery(classtype, params);
		 list = (List<T>) q.execute();
		 pm.close();
	     return list;
	}
	
	@Override
    public <T> T selectByPrimaryKey(Class<T> classtype,Object params) {
        PersistenceManager pm = persistenceManagerFactory.getPersistenceManager();
        T result = null;
        result = pm.getObjectById(classtype, params);
        pm.close();
        return result;
    }
	
	@Override
	public <T> boolean update(T object, int id) {
		boolean flag = false;
		PersistenceManager pm = persistenceManagerFactory.getPersistenceManager();
		Object temp = pm.getObjectById((Class<T>) object.getClass(), id);
		if (temp == null)
			return false;
		BeanUtils.copyProperties(object, temp);
		flag = true;
		return flag;
	}
	
	@Override
	public <T> boolean insert(T object){
		PersistenceManager pm = persistenceManagerFactory.getPersistenceManager();   
		boolean flag = false;;    
        pm.makePersistent(object);           
        pm.close();
        flag=true;
        return flag;
	}
	
	@Override
	public Object selectByProc(String proc,Map<String, Object> params){
		PersistenceManager pm = persistenceManagerFactory.getPersistenceManager();
        Object result = null;
        Query q = pm.newQuery("STOREDPROC", proc);
        StoredProcedureQuery spq = (StoredProcedureQuery) ((JDOQuery) q).getInternalQuery();
        for (String key : params.keySet()) {
            if (key.contains("result"))
                spq.registerParameter(key, params.get(key).getClass(), StoredProcQueryParameterMode.OUT);
            else
                spq.registerParameter(key, params.get(key).getClass(), StoredProcQueryParameterMode.IN);
        }
        spq.executeWithMap(params);
        List results = (List)spq.getNextResults();
        pm.close();
        return results;
	}
}
