package com.shop.wechat.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.common.result.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("短信验证码")
@FeignClient(value="wechat-cloud")
@RequestMapping("/api/sms")
public interface SmsApi {

	@ApiOperation(notes = "获取短信验证码(注册)", value = "获取短信验证码(注册)")
	@PostMapping("smscode")
	public Result loadSMSCode(@ApiParam(value = "手机号码",required=true) @RequestParam String mobile);
	
}
