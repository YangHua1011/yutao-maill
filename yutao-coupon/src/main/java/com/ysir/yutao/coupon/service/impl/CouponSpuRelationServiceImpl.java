package com.ysir.yutao.coupon.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.Query;
import com.ysir.yutao.coupon.dao.CouponSpuRelationDao;
import com.ysir.yutao.coupon.entity.CouponSpuRelationEntity;
import com.ysir.yutao.coupon.service.CouponSpuRelationService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("couponSpuRelationService")
public class CouponSpuRelationServiceImpl extends ServiceImpl<CouponSpuRelationDao, CouponSpuRelationEntity> implements CouponSpuRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CouponSpuRelationEntity> page = this.page(
                new Query<CouponSpuRelationEntity>().getPage(params),
                new QueryWrapper<CouponSpuRelationEntity>()
        );

        return new PageUtils(page);
    }

}