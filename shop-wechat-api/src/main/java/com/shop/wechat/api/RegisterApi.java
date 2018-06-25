package com.shop.wechat.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.common.result.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 注册
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-26 17:27
 */
@Api(tags = "注册")
@FeignClient(value="wechat-cloud")
@RequestMapping("/api/register")
public interface RegisterApi {

	@ApiOperation(notes = "注册", value = "注册")
    @PostMapping("register_by_psd")
    public Result register(@ApiParam(value = "手机号",required=true) @RequestParam String mobile, 
    		@ApiParam(value = "密码",required=true) @RequestParam  String password, HttpServletRequest request);
	
	
	@ApiOperation(notes = "手机短信验证", value = "手机短信验证")
	@PostMapping("validate_by_sms")
	public Result validateSMSCode(@ApiParam(value = "手机号码",required=true) @RequestParam String mobile,
			@ApiParam(value = "验证码",required=true) @RequestParam String code);
	
	
	@ApiOperation(notes = "微信授权登入", value = "微信授权登入")
    @PostMapping("register_by_wechat")
    public Result registerByWeChat(@ApiParam(value = "用户加密数据",required=true) @RequestParam String encryptedData,
			@ApiParam(value = "code",required=true) @RequestParam String code,
			@ApiParam(value = "加密算法矢量",required=true) @RequestParam String iv, HttpServletRequest request);
}
