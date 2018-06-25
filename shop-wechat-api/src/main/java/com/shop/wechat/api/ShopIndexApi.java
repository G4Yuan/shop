package com.shop.wechat.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.common.result.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "首页接口文档")
@FeignClient(value="wechat-cloud")
@RequestMapping("/api/index")
public interface ShopIndexApi {

	@ApiOperation(notes = "首页", value = "首页")
    @GetMapping("index")
    public Result index();
}
