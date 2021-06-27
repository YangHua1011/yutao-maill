package com.ysir.yutao.coupon.controller;


import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.ResponseResult;
import com.ysir.yutao.coupon.entity.SeckillPromotionEntity;
import com.ysir.yutao.coupon.service.SeckillPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 秒杀活动
 *
 * @author 夏沫止水
 * @email HeJieLin@gulimall.com
 * @date 2020-05-22 19:35:30
 */
@RestController
@RequestMapping("coupon/seckillpromotion")
public class SeckillPromotionController {
    @Autowired
    private SeckillPromotionService seckillPromotionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = seckillPromotionService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		SeckillPromotionEntity seckillPromotion = seckillPromotionService.getById(id);

        return ResponseResult.ok().put("seckillPromotion", seckillPromotion);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody SeckillPromotionEntity seckillPromotion){
        seckillPromotion.setUserId(1L);
        seckillPromotion.setCreateTime(new Date());
		seckillPromotionService.save(seckillPromotion);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody SeckillPromotionEntity seckillPromotion){
		seckillPromotionService.updateById(seckillPromotion);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		seckillPromotionService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
