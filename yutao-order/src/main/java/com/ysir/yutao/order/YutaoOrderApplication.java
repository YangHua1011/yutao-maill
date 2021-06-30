package com.ysir.yutao.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class YutaoOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(YutaoOrderApplication.class, args);
	}

}
