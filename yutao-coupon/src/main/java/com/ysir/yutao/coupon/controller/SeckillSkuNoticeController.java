package com.ysir.yutao.coupon.controller;


import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.ResponseResult;
import com.ysir.yutao.coupon.entity.SeckillSkuNoticeEntity;
import com.ysir.yutao.coupon.service.SeckillSkuNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 秒杀商品通知订阅
 *
 * @author 夏沫止水
 * @email HeJieLin@gulimall.com
 * @date 2020-05-22 19:35:30
 */
@RestController
@RequestMapping("coupon/seckillskunotice")
public class SeckillSkuNoticeController {
    @Autowired
    private SeckillSkuNoticeService seckillSkuNoticeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = seckillSkuNoticeService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		SeckillSkuNoticeEntity seckillSkuNotice = seckillSkuNoticeService.getById(id);

        return ResponseResult.ok().put("seckillSkuNotice", seckillSkuNotice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody SeckillSkuNoticeEntity seckillSkuNotice){
		seckillSkuNoticeService.save(seckillSkuNotice);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody SeckillSkuNoticeEntity seckillSkuNotice){
		seckillSkuNoticeService.updateById(seckillSkuNotice);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		seckillSkuNoticeService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
