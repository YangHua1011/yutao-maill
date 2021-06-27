package com.ysir.yutao.coupon.controller;

import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.ResponseResult;
import com.ysir.yutao.coupon.entity.CouponSpuRelationEntity;
import com.ysir.yutao.coupon.service.CouponSpuRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 优惠券与产品关联
 *
 * @author 夏沫止水
 * @email HeJieLin@gulimall.com
 * @date 2020-05-22 19:35:30
 */
@RestController
@RequestMapping("coupon/couponspurelation")
public class CouponSpuRelationController {
    @Autowired
    private CouponSpuRelationService couponSpuRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = couponSpuRelationService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		CouponSpuRelationEntity couponSpuRelation = couponSpuRelationService.getById(id);

        return ResponseResult.ok().put("couponSpuRelation", couponSpuRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody CouponSpuRelationEntity couponSpuRelation){
		couponSpuRelationService.save(couponSpuRelation);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody CouponSpuRelationEntity couponSpuRelation){
		couponSpuRelationService.updateById(couponSpuRelation);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		couponSpuRelationService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
