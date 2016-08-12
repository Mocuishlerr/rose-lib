package com.xionglindong.bean;

import java.util.Date;

public class OperLog {
	private int id;
	private String userName;
	private String resourcePattern;//资源模式
	private String resourceId;     //资源地址
	private int success;          //成功标识
	private String remarks;         //额外说明
	private Date createTime;
	public OperLog(int id, String userName, String resourcePattern, String resourceId, int success, String remarks,
			Date createTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.resourcePattern = resourcePattern;
		this.resourceId = resourceId;
		this.success = success;
		this.remarks = remarks;
		this.createTime = createTime;
	}
	public OperLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getResourcePattern() {
		return resourcePattern;
	}
	public void setResourcePattern(String resourcePattern) {
		this.resourcePattern = resourcePattern;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
