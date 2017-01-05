package com.peakwang.dao;

import java.util.List;
import java.util.Map;

import javax.jdo.*;

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
	/**
     * 通过字段查找
     */
	@Override
	public <T> List<T> selectByQuery(Class<T> classtype,String params){
		 PersistenceManager pm = persistenceManagerFactory.getPersistenceManager();
	     List<T> list = null;
	     Query q = pm.newQuery(classtype, params);
		 list = (List<T>) q.execute();
		 pm.close();
	     return list;
	}
	/**
     * 通过主键查找
     */
	@Override
    public <T> T selectByPrimaryKey(Class<T> classtype,Object params) {
        PersistenceManager pm = persistenceManagerFactory.getPersistenceManager();
        T result = null;
        result = pm.getObjectById(classtype, params);
        pm.close();
        return result;
    }
	/**
     * 更新
     */
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
	/**
     * 插入
     */
	@Override
	public <T> void insert(T object){
		PersistenceManager pm = persistenceManagerFactory.getPersistenceManager();   		    
        pm.makePersistent(object);           
        pm.close();
	}
	/**
     * 存储过程，正在研究中
     */
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
