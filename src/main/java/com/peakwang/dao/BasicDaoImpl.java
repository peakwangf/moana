package com.peakwang.dao;

import java.util.List;
import java.util.Map;
import javax.jdo.*;
import javax.jdo.annotations.PrimaryKey;
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
	        return list;
	}
}
