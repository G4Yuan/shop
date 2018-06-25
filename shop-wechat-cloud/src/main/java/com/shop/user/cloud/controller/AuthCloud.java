package com.shop.user.cloud.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.shop.common.annotation.IgnoreAuth;
import com.shop.common.result.Result;
import com.shop.common.result.ResultCode;
import com.shop.common.result.ResultGenerator;
import com.shop.wechat.api.AuthApi;
import com.shop.user.cloud.pojo.UserResponse;
import com.shop.user.cloud.service.UserService;


@RestController
public class AuthCloud implements AuthApi {

	@Autowired
	private UserService userService;

	@IgnoreAuth
	@Override
	public Result login(String mobile, String password, HttpServletRequest request) {
		
		if (StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(password)) {
			// 用户登录
			UserResponse response = userService.login(mobile, password);
			if (response != null) {
				return ResultGenerator.genSuccessResult("登入成功!", response);
			}
			return ResultGenerator.genFailResult(ResultCode.PASSWORD_IS_ERROR.code, "密码错误!");
		}
		
		return ResultGenerator.genFailResult(ResultCode.MOBILE_OR_PSD_IS_NULL.code, "手机或密码为空!");

	}


}
