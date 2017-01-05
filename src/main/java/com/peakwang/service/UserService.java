package com.peakwang.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;

import com.peakwang.dao.BasicDao;
import com.peakwang.model.RecordVo;
import com.peakwang.model.MovieTicket;
import com.peakwang.model.Record;
import com.peakwang.model.User;

@Service
public class UserService {

	@Autowired
	@Qualifier("basicDaoImpl")
	private BasicDao basicDao;
	
	/**
     * 返回已购列表
     */
	public List<RecordVo> getRecordsByUid(int uid){
		List<RecordVo> list = new ArrayList<RecordVo>();
		String params="uid=="+uid;
		List<Record> records=basicDao.selectByQuery(Record.class,params);
		for(Record record:records)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			RecordVo recordVo=new RecordVo();
			recordVo.setGrabTime(sdf.format(record.getGrabTime()));
			MovieTicket movieTicket=basicDao.selectByPrimaryKey(MovieTicket.class,record.getTid());
			recordVo.setMovieName(movieTicket.getMovieName());
			recordVo.setRunTime(sdf.format(movieTicket.getRunTime()));
			list.add(recordVo);
		}
		return list;
	}
	/**
     * 通过用户ID查找用户
     */
	public User getUserById(int uid){
		User user=basicDao.selectByPrimaryKey(User.class,uid);
		return user;
	}
	/**
     * 添加用户
     */
	public void add(User user){
		basicDao.insert(user);
	}
}
