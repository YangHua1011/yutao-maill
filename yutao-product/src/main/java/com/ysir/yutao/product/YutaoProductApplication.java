package com.ysir.yutao.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.ysir.yutao.product.feign")
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.ysir.yutao.product.dao")
public class YutaoProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(YutaoProductApplication.class, args);
	}

}
