//package com.shop.user.cloud.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//@Configuration
//@PropertySource("classpath:application.yml")
//public class AliSmsConfig {
//
//	@Value("${aliyun.sms.accesskey}")
//    private String accessKey;
//	@Value("${aliyun.sms.accesskey_secret}")
//    private String secretKey;
//	@Value("${aliyun.sms.sign_name}")
//    private String signName;
//	@Value("${aliyun.sms.sms_temp}")
//    private String smsTemp;
//	public String getAccessKey() {
//		return accessKey;
//	}
//	public void setAccessKey(String accessKey) {
//		this.accessKey = accessKey;
//	}
//	public String getSecretKey() {
//		return secretKey;
//	}
//	public void setSecretKey(String secretKey) {
//		this.secretKey = secretKey;
//	}
//	public String getSignName() {
//		return signName;
//	}
//	public void setSignName(String signName) {
//		this.signName = signName;
//	}
//	public String getSmsTemp() {
//		return smsTemp;
//	}
//	public void setSmsTemp(String smsTemp) {
//		this.smsTemp = smsTemp;
//	}
//	
//}
