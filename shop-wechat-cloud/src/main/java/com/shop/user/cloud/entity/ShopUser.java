package com.shop.user.cloud.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author Yuan Wei
 * @email ywdeveloper@aliyun.com
 * @date 2018-06-14 16:05:53
 */
public class ShopUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
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
	//用户密码
	private String password;
	//手机号
	private String mobile;
	//用户生日
	private Date birthday;
	//注册时间
	private Date registerTime;
	//最后登入时间
	private Date lastLoginTime;
	//最后登入IP
	private String lastLoginIp;
	//用户等级
	private Integer userLevelId;
	//注册IP
	private String registerIp;
	//用户类型
	private Integer userType;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：用户标识
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * 获取：用户标识
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * 设置：昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：性别 1_男 2_女
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	/**
	 * 获取：性别 1_男 2_女
	 */
	public Integer getGender() {
		return gender;
	}
	/**
	 * 设置：省份
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省份
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：国家
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * 获取：国家
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * 设置：头像
	 */
	public void setAvatarurl(String avatarurl) {
		this.avatarurl = avatarurl;
	}
	/**
	 * 获取：头像
	 */
	public String getAvatarurl() {
		return avatarurl;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：用户密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：用户密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：用户生日
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：用户生日
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * 设置：注册时间
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	/**
	 * 获取：注册时间
	 */
	public Date getRegisterTime() {
		return registerTime;
	}
	/**
	 * 设置：最后登入时间
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	/**
	 * 获取：最后登入时间
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	/**
	 * 设置：最后登入IP
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	/**
	 * 获取：最后登入IP
	 */
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	/**
	 * 设置：用户等级
	 */
	public void setUserLevelId(Integer userLevelId) {
		this.userLevelId = userLevelId;
	}
	/**
	 * 获取：用户等级
	 */
	public Integer getUserLevelId() {
		return userLevelId;
	}
	/**
	 * 设置：注册IP
	 */
	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}
	/**
	 * 获取：注册IP
	 */
	public String getRegisterIp() {
		return registerIp;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
	
}
