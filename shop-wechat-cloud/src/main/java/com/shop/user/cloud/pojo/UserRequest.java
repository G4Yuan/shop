package com.shop.user.cloud.pojo;

import java.io.Serializable;
import java.util.Date;

public class UserRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String userId;
	//头像
	private String avatarurl;
	//用户姓名
	private String username;
	//用户生日
	private Date birthday;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAvatarurl() {
		return avatarurl;
	}
	public void setAvatarurl(String avatarurl) {
		this.avatarurl = avatarurl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	
}
