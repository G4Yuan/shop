package com.shop.user.cloud.pojo;


import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class UserInfoResponse implements Serializable{
	
    private static final long serialVersionUID = 7334926332405683381L;
	
    @ApiModelProperty(value="用户openid")
    private String openId;
    @ApiModelProperty(value="昵称")
    private String nickName;
    @ApiModelProperty(value="性别")
    private Integer gender;
    @ApiModelProperty(value="城市")
    private String city;
    @ApiModelProperty(value="省份")
    private String province;
    @ApiModelProperty(value="国家")
    private String country;
    @ApiModelProperty(value="头像")
    private String avatarUrl;
    @ApiModelProperty(value="用户unionId")
    private String unionId;
    @ApiModelProperty(value="Watermark")
    private Watermark watermark;
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
	public Watermark getWatermark() {
		return watermark;
	}
	public void setWatermark(Watermark watermark) {
		this.watermark = watermark;
	}
}
