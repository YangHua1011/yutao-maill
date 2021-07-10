package com.ysir.yutao.ware.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.api.R;
import com.ysir.yutao.common.to.SkuHasStockVo;
import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.ResponseResult;
import com.ysir.yutao.ware.entity.WareSkuEntity;
import com.ysir.yutao.ware.service.WareSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 商品库存
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-08 09:59:40
 */
@RestController
@RequestMapping("ware/waresku")
public class WareSkuController {
    @Autowired
    private WareSkuService wareSkuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:waresku:list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = wareSkuService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }

    /**
     * 查询sku是否有库存
     * @return
     */
    @PostMapping(value = "/hasStock")
    public ResponseResult getSkuHasStock(@RequestBody List<Long> skuIds) {

        //skuId stock
        List<SkuHasStockVo> vos = wareSkuService.getSkuHasStock(skuIds);

        return ResponseResult.ok().setData(vos);

    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:waresku:info")
    public ResponseResult info(@PathVariable("id") Long id){
		WareSkuEntity wareSku = wareSkuService.getById(id);

        return ResponseResult.ok().put("wareSku", wareSku);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:waresku:save")
    public ResponseResult save(@RequestBody WareSkuEntity wareSku){
		wareSkuService.save(wareSku);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:waresku:update")
    public ResponseResult update(@RequestBody WareSkuEntity wareSku){
		wareSkuService.updateById(wareSku);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:waresku:delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		wareSkuService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
