package com.ysir.yutao.coupon.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.coupon.entity.CouponEntity;

import java.util.Map;

/**
 * 优惠券信息
 *
 * @author 夏沫止水
 * @email HeJieLin@gulimall.com
 * @date 2020-05-22 19:35:30
 */
public interface CouponService extends IService<CouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

