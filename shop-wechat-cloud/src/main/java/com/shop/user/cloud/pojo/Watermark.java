package com.shop.user.cloud.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class Watermark implements Serializable{

	private static final long serialVersionUID = 7334926332405683381L;
	
	@ApiModelProperty(value="appid")
	private String appid;
	@ApiModelProperty(value="时间戳")
	private long timestamp;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
}
