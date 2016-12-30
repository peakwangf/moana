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
	@Column(length=20)
	private String userName;
	/**
     * 密码
     */
	@Column(length=20)
	private String passWord;
	/**
     * 用户邮箱
     */
	@Column(length=30)
	private String email;
	
	private int leftGrabNum;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
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
