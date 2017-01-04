package com.peakwang.dao;

import java.util.List;
import java.util.Map;

public interface BasicDao {

	<T> List<T> selectByQuery(Class<T> classtype,String params);
	<T> T selectByPrimaryKey(Class<T> classtype,Object params);
	Object selectByProc(String proc,Map<String, Object> params);
	<T> boolean update(T object,int id);
	<T> void insert(T object);
}
