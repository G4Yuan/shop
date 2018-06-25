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
 * API登录授权
 *
 * @author YuanWei
 * @email ywdeveloper@aliyun.com
 * @date 2018-06-19
 */
@Api(tags = "API登录授权")
@FeignClient(value="wechat-cloud")
@RequestMapping("/api/auth")
public interface AuthApi {

	@ApiOperation(notes = "手机密码登录", value = "手机密码登录")
    @PostMapping("login")
    public Result login(@ApiParam(value = "手机号码",required=true) @RequestParam String mobile, 
    		@ApiParam(value = "密码",required=true) @RequestParam String password,
    		HttpServletRequest request);


}
