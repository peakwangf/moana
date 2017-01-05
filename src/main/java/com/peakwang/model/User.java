	package com.peakwang.model;

import javax.jdo.annotations.*;

@PersistenceCapable(table="user")
public class User {
	
	/**
     * 用户ID
     */
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private int uid;
	/**
     * 用户名
     */
	private String userName;
	/**
     * 密码
     */
	
	private String passWord;
	/**
     * 用户邮箱
     */
	
	private String email;
	/**
     * 剩余可抢购数量
     */
	private int leftGrabNum;
	
	
	public int getUid() {
	    return uid;
	}

	public void setUid(int id) {
	    this.uid = id;
	}
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getLeftGrabNum() {
        return leftGrabNum;
    }

    public void setLeftGrabNum(int leftGrabNum) {
        this.leftGrabNum = leftGrabNum;
    }
}
