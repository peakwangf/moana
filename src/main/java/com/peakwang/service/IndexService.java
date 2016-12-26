package com.peakwang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.peakwang.dao.BasicDao;
import com.peakwang.model.MovieTicket;

@Service
public class IndexService {
	@Autowired
	@Qualifier("basicDaoImpl")
	private BasicDao basicDao;
	
	
	public List<MovieTicket> getAllMovieTicket(){
		List<MovieTicket> movieTicket=basicDao.selectByQuery(MovieTicket.class,"");
		return movieTicket;
	}

}
