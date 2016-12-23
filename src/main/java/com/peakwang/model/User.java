package com.peakwang.model;

import javax.jdo.annotations.*;

@PersistenceCapable(table="user")
public class User {
	
	/**
     * 用户ID
     */
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private int userid;
	/**
     * 用户名
     */
	@Column(length=20)
	private String username;
	/**
     * 密码
     */
	@Column(length=20)
	private String password;
	/**
     * 用户邮箱
     */
	@Column(length=30)
	private String email;
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
	    return userid;
	}

	public void setId(int id) {
	    this.userid = id;
	}
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
