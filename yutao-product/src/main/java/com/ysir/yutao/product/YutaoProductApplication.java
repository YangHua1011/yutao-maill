package com.ysir.yutao.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ysir.yutao.product.dao")
public class YutaoProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(YutaoProductApplication.class, args);
	}

}
