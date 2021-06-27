package com.ysir.yutao.coupon.controller;

import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.ResponseResult;
import com.ysir.yutao.coupon.entity.CouponSpuCategoryRelationEntity;
import com.ysir.yutao.coupon.service.CouponSpuCategoryRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 优惠券分类关联
 *
 * @author 夏沫止水
 * @email HeJieLin@gulimall.com
 * @date 2020-05-22 19:35:30
 */
@RestController
@RequestMapping("coupon/couponspucategoryrelation")
public class CouponSpuCategoryRelationController {
    @Autowired
    private CouponSpuCategoryRelationService couponSpuCategoryRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = couponSpuCategoryRelationService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		CouponSpuCategoryRelationEntity couponSpuCategoryRelation = couponSpuCategoryRelationService.getById(id);

        return ResponseResult.ok().put("couponSpuCategoryRelation", couponSpuCategoryRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody CouponSpuCategoryRelationEntity couponSpuCategoryRelation){
		couponSpuCategoryRelationService.save(couponSpuCategoryRelation);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody CouponSpuCategoryRelationEntity couponSpuCategoryRelation){
		couponSpuCategoryRelationService.updateById(couponSpuCategoryRelation);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		couponSpuCategoryRelationService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
