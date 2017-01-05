package com.peakwang.service;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.peakwang.dao.BasicDao;
import com.peakwang.model.MovieTicket;
import com.peakwang.model.User;
import com.peakwang.model.Record;

@Service
public class IndexService {
	@Autowired
	@Qualifier("basicDaoImpl")
	private BasicDao basicDao;
	
	@Autowired 
	private UserService userService;

	
	/**
     * 获取电影票列表
     */
	public List<MovieTicket> getAllMovieTicket(){
		List<MovieTicket> movieTicket=basicDao.selectByQuery(MovieTicket.class,"");
		return movieTicket;
	}
	/**
     * 通过电影票ID查找电影票
     */
	public MovieTicket getMovieTicketById(int id){
		MovieTicket movieTicket=basicDao.selectByPrimaryKey(MovieTicket.class,id);
		return movieTicket;
	}
	/**
     * 抢购
     */
	public String grab(int uid,int tid){
		String message=null;
		User user=userService.getUserById(uid);
		int uNum =user.getLeftGrabNum();
		MovieTicket movieTicket=getMovieTicketById(tid);
		int tNum=movieTicket.getTicketNum();
		if(uNum==0){
			message="您已没有抢购额度！！！";
			return message;
		}
		if(tNum==0){
			message="该电影票已被抢完！！！";
		}else{
			movieTicket.setTicketNum(tNum-1);
			boolean s=basicDao.update(movieTicket, tid);
			if(s==true){
				message="抢票成功！！！";
				user.setLeftGrabNum(uNum-1);
				basicDao.update(user, uid);
				Record record=new Record();
				record.setUid(uid);
				record.setTid(tid);
				Date date =new Date();
				record.setGrabTime(date);
				basicDao.insert(record);
			}
			else
				message="抢票失败！！！";
		}
		return message;
	}
}
