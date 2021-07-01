package com.ysir.yutao.order.controller;

import com.ysir.yutao.common.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
@RequestMapping("/order/config")
public class ConfigController {

    @Value(value = "${order.env}")
    String dev;

    @RequestMapping("/getEnv")
    public ResponseResult getConfig() {
        return ResponseResult.ok().put("dev:", dev);
    }
}
