package com.ysir.yutao.search.feign;

import com.ysir.yutao.common.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-06-18 09:15
 **/

@FeignClient("mall-product")
public interface ProductFeignService {

    @GetMapping("/product/attr/info/{attrId}")
    public ResponseResult attrInfo(@PathVariable("attrId") Long attrId);

}
