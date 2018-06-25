package com.shop.user.cloud.pojo;

import java.io.Serializable;
import java.util.Date;

import com.shop.user.cloud.entity.ShopUser;


public class UserResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//用户ID
	private String userId;
	//用户标识
	private String openid;
	//昵称
	private String nickname;
	//性别 1_男 2_女
	private Integer gender;
	//省份
	private String province;
	//城市
	private String city;
	//国家
	private String country;
	//头像
	private String avatarurl;
	//用户姓名
	private String username;
	//手机号
	private String mobile;
	//用户生日
	private Date birthday;
	//用户等级
	private Integer userLevelId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getUserLevelId() {
		return userLevelId;
	}
	public void setUserLevelId(Integer userLevelId) {
		this.userLevelId = userLevelId;
	}
	
	public static UserResponse fromBean(ShopUser user) {
		UserResponse response = new UserResponse();
		response.setUserId(user.getId());
		response.setOpenid(user.getOpenid());
		response.setNickname(user.getNickname());
		response.setGender(user.getGender());
		response.setProvince(user.getProvince());
		response.setCity(user.getCity());
		response.setCountry(user.getCountry());
		response.setAvatarurl(user.getAvatarurl());
		response.setUsername(user.getUsername());
		response.setMobile(user.getMobile());
		response.setBirthday(user.getBirthday());
		response.setUserLevelId(user.getUserLevelId());
		return response;
	}
}
