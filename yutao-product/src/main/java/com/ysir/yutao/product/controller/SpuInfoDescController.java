package com.ysir.yutao.product.controller;

import java.util.Arrays;
import java.util.Map;

import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.ResponseResult;
import com.ysir.yutao.product.entity.SpuInfoDescEntity;
import com.ysir.yutao.product.service.SpuInfoDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * spu信息介绍
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-01 22:50:32
 */
@RestController
@RequestMapping("product/spuinfodesc")
public class SpuInfoDescController {
    @Autowired
    private SpuInfoDescService spuInfoDescService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = spuInfoDescService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{spuId}")
    public ResponseResult info(@PathVariable("spuId") Long spuId){
		SpuInfoDescEntity spuInfoDesc = spuInfoDescService.getById(spuId);

        return ResponseResult.ok().put("spuInfoDesc", spuInfoDesc);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody SpuInfoDescEntity spuInfoDesc){
		spuInfoDescService.save(spuInfoDesc);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody SpuInfoDescEntity spuInfoDesc){
		spuInfoDescService.updateById(spuInfoDesc);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] spuIds){
		spuInfoDescService.removeByIds(Arrays.asList(spuIds));

        return ResponseResult.ok();
    }

}
