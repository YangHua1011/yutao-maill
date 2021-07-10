package com.ysir.yutao.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@MapperScan("com.ysir.yutao.ware.dao")
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.ysir.yutao.ware.feign"})
public class YutaoWareApplication {

	public static void main(String[] args) {
		SpringApplication.run(YutaoWareApplication.class, args);
	}

}
