package com.peakwang.model;

import javax.jdo.annotations.*;

@PersistenceCapable(table="user")
public class User {
	
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private int id;
	
	@Column(length=20)
	private String username;
	
	@Column(length=20)
	private String password;
	
	@Column(length=30)
	private String email;
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
	    return id;
	}

	public void setId(int id) {
	    this.id = id;
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
