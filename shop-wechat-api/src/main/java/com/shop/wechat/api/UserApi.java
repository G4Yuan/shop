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

@Api("用户信息")
@FeignClient(value="wechat-cloud")
@RequestMapping("/api/user")
public interface UserApi {

	@ApiOperation(notes = "修改用户信息", value = "修改用户信息")
	@PostMapping("update_user")
	public Result updateUser(@ApiParam(value = "用户信息",required=true) @RequestParam Object object);
	
	
	@ApiOperation(notes = "修改用户密码", value = "修改用户密码")
	@PostMapping("update_user_psd")
	public Result updateUserPsd(@ApiParam(value = "旧密码",required=true) @RequestParam String oldPassword,
			@ApiParam(value = "新密码",required=true) @RequestParam String newPassword, HttpServletRequest request);
	
	
	@ApiOperation(notes = "修改用户密码(短信验证)", value = "修改用户密码(短信验证)")
	@PostMapping("update_user_psd_sms")
	public Result updateUserPsdBySms(@ApiParam(value = "新密码",required=true) @RequestParam String newPassword, HttpServletRequest request);
	
	
	@ApiOperation(notes = "修改绑定手机", value = "修改绑定手机")
	@PostMapping("update_user_mobile")
	public Result updateUserMobile(@ApiParam(value = "新手机",required=true) @RequestParam String newMobile, HttpServletRequest request);
}
