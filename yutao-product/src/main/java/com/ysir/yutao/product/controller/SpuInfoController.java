package com.ysir.yutao.product.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.extension.api.R;
import com.ysir.yutao.common.utils.ResponseResult;
import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.product.entity.SpuInfoEntity;
import com.ysir.yutao.product.service.SpuInfoService;
import com.ysir.yutao.product.vo.SpuSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * spu信息
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-01 22:50:32
 */
@RestController
@RequestMapping("product/spuinfo")
public class SpuInfoController {
    @Autowired
    private SpuInfoService spuInfoService;

    /**
     * 根据skuId查询spu的信息
     * @param skuId
     * @return
     */
    @GetMapping(value = "/skuId/{skuId}")
    public ResponseResult getSpuInfoBySkuId(@PathVariable("skuId") Long skuId) {

        SpuInfoEntity spuInfoEntity = spuInfoService.getSpuInfoBySkuId(skuId);

        return ResponseResult.ok().setData(spuInfoEntity);
    }

    @GetMapping(value = "/{spuId}/up")
    public ResponseResult spuUp(@PathVariable("spuId") Long spuId) {

        spuInfoService.up(spuId);

        return ResponseResult.ok();
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = spuInfoService.queryPageByCondition(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		SpuInfoEntity spuInfo = spuInfoService.getById(id);

        return ResponseResult.ok().put("spuInfo", spuInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody SpuSaveVo vo){
		//spuInfoService.save(spuInfo);

        spuInfoService.saveSpuInfo(vo);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody SpuInfoEntity spuInfo){
		spuInfoService.updateById(spuInfo);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		spuInfoService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
