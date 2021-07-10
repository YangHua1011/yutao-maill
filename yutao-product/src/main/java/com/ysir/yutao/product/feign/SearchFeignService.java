package com.ysir.yutao.product.feign;

import com.ysir.yutao.common.es.SkuEsModel;
import com.ysir.yutao.common.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-06-06 17:12
 **/

@FeignClient("mall-search")
public interface SearchFeignService {

    @PostMapping(value = "/search/save/product")
    public ResponseResult productStatusUp(@RequestBody List<SkuEsModel> skuEsModels);

}
