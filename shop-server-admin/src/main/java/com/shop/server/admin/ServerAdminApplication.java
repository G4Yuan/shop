package com.shop.server.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;


@Configuration
@EnableAutoConfiguration
@EnableAdminServer
@EnableDiscoveryClient
public class ServerAdminApplication {


	public static void main(String[] args) throws Exception {
		SpringApplication.run(ServerAdminApplication.class, args);
	}

}
