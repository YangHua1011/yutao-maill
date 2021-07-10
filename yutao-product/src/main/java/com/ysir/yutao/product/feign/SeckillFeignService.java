package com.ysir.yutao.product.feign;

import com.ysir.yutao.common.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-07-10 15:53
 **/

@FeignClient(value = "mall-seckill"/*,fallback = SeckillFeignServiceFallBack.class*/)
public interface SeckillFeignService {

    /**
     * 根据skuId查询商品是否参加秒杀活动
     * @param skuId
     * @return
     */
    @GetMapping(value = "/sku/seckill/{skuId}")
    ResponseResult getSkuSeckilInfo(@PathVariable("skuId") Long skuId);

}
