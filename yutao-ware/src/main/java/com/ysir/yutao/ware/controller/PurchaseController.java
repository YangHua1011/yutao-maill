package com.ysir.yutao.ware.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.ware.entity.PurchaseEntity;
import com.ysir.yutao.ware.service.PurchaseService;
import com.ysir.yutao.ware.vo.MergeVo;
import com.ysir.yutao.ware.vo.PurchaseDoneVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ysir.yutao.common.utils.ResponseResult;



/**
 * 采购信息
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-11-17 13:50:10
 */
@RestController
@RequestMapping("ware/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/done")
    public ResponseResult finish(@RequestBody PurchaseDoneVo doneVo){

        purchaseService.done(doneVo);

        return ResponseResult.ok();
    }

    /**
     * 领取采购单
     * @return
     */
    @PostMapping("/received")
    public ResponseResult received(@RequestBody List<Long> ids){

        purchaseService.received(ids);

        return ResponseResult.ok();
    }

    @PostMapping("/merge")
    public ResponseResult merge(@RequestBody MergeVo mergeVo){

        purchaseService.mergePurchase(mergeVo);
        return ResponseResult.ok();
    }

    @RequestMapping("/unreceive/list")
    public ResponseResult unreceivelist(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPageUnreceivePurchase(params);

        return ResponseResult.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		PurchaseEntity purchase = purchaseService.getById(id);

        return ResponseResult.ok().put("purchase", purchase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody PurchaseEntity purchase){
        purchase.setUpdateTime(new Date());
        purchase.setCreateTime(new Date());
		purchaseService.save(purchase);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody PurchaseEntity purchase){
		purchaseService.updateById(purchase);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		purchaseService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
