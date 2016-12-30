package com.peakwang.dao;

import java.util.List;
import javax.jdo.*;
import java.lang.reflect.Field;


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
        return result;
    }
}
