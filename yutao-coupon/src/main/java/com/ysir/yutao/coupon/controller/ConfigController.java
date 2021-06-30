package com.ysir.yutao.coupon.controller;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.ysir.yutao.common.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
@RequestMapping("/coupon/config")
@NacosConfigurationProperties(dataId = "mall-coupon.properties",autoRefreshed = true)
public class ConfigController {

    @NacosValue(value = "${coupon.name}",autoRefreshed = true)
    String name;
    @NacosValue(value = "${coupon.password}",autoRefreshed = true)
    String password;

    @RequestMapping("/find")
    public ResponseResult getConfig() {
        return ResponseResult.ok().put("name", name).put("pwd", password);
    }
}
