package com.xionglindong.bean;

import java.util.Date;

public class User {
	public static final String USER_STATUS_GIVE_BACK="give_back";//归还
	public static final String USER_STATUS_STAY="stay";//保留
	
	private int id;
	private String loginName;
	private String password;
	private String name;
	private Date createTime;
	private int groups;
	private String userStatus;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String loginName, String password, String name,
			Date createTime, int groups, String userStatus) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.password = password;
		this.createTime = createTime;
		this.name = name;
		this.groups = groups;
		this.userStatus = userStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGroups() {
		return groups;
	}

	public void setGroups(int groups) {
		this.groups = groups;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

}
