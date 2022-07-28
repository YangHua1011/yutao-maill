package com.ysir.yutao.ware;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;


class YutaoWareApplicationTests {

	@Test
	void contextLoads() {
		BigDecimal bigDecimal = new BigDecimal(0);
		BigDecimal bigDecimal1 = new BigDecimal(1);
		System.out.println(bigDecimal.equals(bigDecimal1));
	}

}
