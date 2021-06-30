package com.ysir.yutao.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.ysir.yutao.member.feign")
public class YutaoMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(YutaoMemberApplication.class, args);
	}

}
