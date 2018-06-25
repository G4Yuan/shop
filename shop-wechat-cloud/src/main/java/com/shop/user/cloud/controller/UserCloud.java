package com.shop.user.cloud.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.shop.common.annotation.LoginUser;
import com.shop.common.result.Result;
import com.shop.common.result.ResultCode;
import com.shop.common.result.ResultGenerator;
import com.shop.wechat.api.UserApi;
import com.shop.user.cloud.entity.ShopUser;
import com.shop.user.cloud.interceptor.AuthorizationInterceptor;
import com.shop.user.cloud.service.UserService;

@RestController
public class UserCloud implements UserApi{

	@Autowired
	private UserService userService;
	
	@Override
	public Result updateUser(@LoginUser Object object) {

		ShopUser shopUser = null;
		if (object instanceof ShopUser) {
			shopUser = (ShopUser) object;
		}
		if (shopUser != null) {
			//更新用户信息
			userService.update(shopUser);
			
			return ResultGenerator.genSuccessResult("更新用户信息成功");
		}
		return ResultGenerator.genFailResult("用户不存在!");
	}

	@Override
	public Result updateUserPsd(String oldPassword, String newPassword, HttpServletRequest request) {

		String token = (String) request.getAttribute(AuthorizationInterceptor.LOGIN_USER_KEY);
		ShopUser shopUser = userService.queryObject(token);
		
		if (shopUser != null) {
			//判断密码是否输入正确
			if (shopUser.getPassword().equals(DigestUtils.md5Hex(oldPassword))) {
				shopUser.setPassword(DigestUtils.md5Hex(newPassword));
				userService.update(shopUser);
				
				return ResultGenerator.genSuccessResult("更新密码成功");
			}else {
				return ResultGenerator.genFailResult(ResultCode.PASSWORD_IS_ERROR.code, "密码输入错误");
			}
		}
		return ResultGenerator.genFailResult("用户不存在!");
	}

	@Override
	public Result updateUserPsdBySms(String newPassword, HttpServletRequest request) {
		String token = (String) request.getAttribute(AuthorizationInterceptor.LOGIN_USER_KEY);
		ShopUser shopUser = userService.queryObject(token);
		
		if (shopUser != null) {
			shopUser.setPassword(DigestUtils.md5Hex(newPassword));
			userService.update(shopUser);
			
			return ResultGenerator.genSuccessResult("更新密码成功");
		}
		return ResultGenerator.genFailResult("用户不存在!");
	}

	@Override
	public Result updateUserMobile(String newMobile, HttpServletRequest request) {
		String token = (String) request.getAttribute(AuthorizationInterceptor.LOGIN_USER_KEY);
		ShopUser shopUser = userService.queryObject(token);
		
		if (shopUser != null) {
			shopUser.setMobile(newMobile);
			userService.update(shopUser);
			
			return ResultGenerator.genSuccessResult("更新绑定手机成功");
		}
		return ResultGenerator.genFailResult("用户不存在!");
	}

}
