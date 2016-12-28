package com.peakwang.dao;

import java.util.List;

public interface BasicDao {

	<T> List<T> selectByQuery(Class<T> classtype,String params);
	<T> T selectByPrimaryKey(Class<T> classtype,Object params);
}
