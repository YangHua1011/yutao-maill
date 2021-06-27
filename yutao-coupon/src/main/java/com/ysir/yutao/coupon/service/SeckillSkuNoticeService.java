package com.ysir.yutao.coupon.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.coupon.entity.SeckillSkuNoticeEntity;

import java.util.Map;

/**
 * 秒杀商品通知订阅
 *
 * @author 夏沫止水
 * @email HeJieLin@gulimall.com
 * @date 2020-05-22 19:35:30
 */
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

