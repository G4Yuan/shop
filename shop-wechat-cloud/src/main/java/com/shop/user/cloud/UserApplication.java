package com.shop.user.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.shop.common.swagger.EnableMySwagger;

@EnableMySwagger
@EnableDiscoveryClient
@EnableFeignClients
@EnableEurekaClient
@RefreshScope
@SpringBootApplication
@MapperScan({"com.shop.user.cloud.dao.*"})
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
