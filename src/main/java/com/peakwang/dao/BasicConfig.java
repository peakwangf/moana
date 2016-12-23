package com.peakwang.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

@Configuration
public class BasicConfig {

	@Bean
    @Scope
	public PersistenceManagerFactory getPersistenceManagerFactory() {
		return JDOHelper.getPersistenceManagerFactory("Tutorial");// TODO Auto-generated constructor stub
	}

}
