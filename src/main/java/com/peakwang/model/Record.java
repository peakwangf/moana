package com.peakwang.model;

import javax.jdo.annotations.*;
import java.util.Date;

@PersistenceCapable(table="record")
public class Record {
	/**
     * 记录ID
     */
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private int rid;
	
	/**
     * 用户ID
     */
	private int uid;
	
	/**
     * 电泳票ID
     */
	private int tid;
	
	/**
     * 抢购时间
     */
	private Date grabTime;
	
	public int getRid(){
		return rid;
	}
	public void setRid(int rid){
		this.rid=rid;
	}
	
	public int getUid(){
		return uid;
	}
	public void setUid(int uid){
		this.uid=uid;
	}
	
	public int getTid(){
		return tid;
	}
	public void setTid(int tid){
		this.tid=tid;
	}
	
	public Date getGrabTime(){
		return grabTime;
	}
	public void setGrabTime(Date grabTime){
		this.grabTime=grabTime;
	}
}
