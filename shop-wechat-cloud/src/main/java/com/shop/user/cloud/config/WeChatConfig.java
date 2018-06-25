//package com.shop.user.cloud.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//@Configuration
//@PropertySource("classpath:application.yml")
//public class WeChatConfig {
//
//	@Value("${wx.appid}")
//    private String appid;
//	
//	@Value("${wx.sercet}")
//    private String sercet;
//
//	public String getAppid() {
//		return appid;
//	}
//
//	public void setAppid(String appid) {
//		this.appid = appid;
//	}
//
//	public String getSercet() {
//		return sercet;
//	}
//
//	public void setSercet(String sercet) {
//		this.sercet = sercet;
//	}
//	
//	
//}