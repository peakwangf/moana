package com.peakwang.service;

import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.peakwang.dao.BasicDao;
import com.peakwang.model.User;


@Service
public class LoginService {
	@Autowired
	@Qualifier("basicDaoImpl")
	private BasicDao basicDao;
	
	
	public List<User> loginByUsername(String username){
		String params="userName=='"+username+"'";
		List<User> users=basicDao.selectByQuery(User.class,params);
		return users;
	}
	

}
