//package com.shop.user.cloud.controller;
//
//
//import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.aliyuncs.exceptions.ClientException;
//import com.shop.common.result.Result;
//import com.shop.common.result.ResultCode;
//import com.shop.common.result.ResultGenerator;
//import com.shop.wechat.api.SmsApi;
//import com.shop.user.cloud.config.AliSmsConfig;
//import com.shop.user.cloud.cons.SmsConstant;
//import com.shop.user.cloud.utils.AliSendSMSTool;
//import com.shop.user.cloud.utils.RedisUtil;
//
//
//@RestController
//public class SmsCloud implements SmsApi{
//
//	@Autowired
//	private AliSmsConfig smsConfig;
//	
//	@Override
//	public Result loadSMSCode(String mobile) {
//		
//		return setSmsCodeToRedis(mobile, SmsConstant.VALIDATE_SMS_PREFIX);
//	}
//
//	
//	private Result setSmsCodeToRedis(String mobile, String prefix) {
//		
//		//生成随机6位数
//		int randomNum = (int)((Math.random() * 9 + 1 ) * 100000);
//				
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("code", String.valueOf(randomNum));
//		//大鱼短信
//		JSON json = null;
//		try {
//			json = AliSendSMSTool.sendSms(smsConfig.getAccessKey(), smsConfig.getSecretKey(), smsConfig.getSignName(), smsConfig.getSmsTemp(), mobile, jsonObject.toJSONString());
//		} catch (ClientException e) {
//			e.printStackTrace();
//			return ResultGenerator.genFailResult(ResultCode.KAPTCHA_ERROR.code, "短信验证码获取失败!");
//		}
//		//获取大鱼返回信息
//		JSONObject aliJSON = (JSONObject) json;
//		if (StringUtils.isNoneBlank(aliJSON.getString("code")) && aliJSON.getString("code").equalsIgnoreCase("OK")) {
//			//MD5加签
//			String code = DigestUtils.md5Hex(mobile + String.valueOf(randomNum));
//			
//			//放入缓存
//			boolean result = RedisUtil.hasKey(prefix + mobile);
//			if (result) {
//				RedisUtil.del(prefix + mobile);
//			}
//			RedisUtil.set(prefix + mobile, code);
//			RedisUtil.expire(prefix + mobile, 120);
//		}
//		
//		return ResultGenerator.genSuccessResult("短信验证码获取成功!", jsonObject);
//	}
//
//}
