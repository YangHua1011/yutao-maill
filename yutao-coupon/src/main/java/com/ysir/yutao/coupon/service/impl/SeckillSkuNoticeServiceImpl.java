package com.ysir.yutao.coupon.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.Query;
import com.ysir.yutao.coupon.dao.SeckillSkuNoticeDao;
import com.ysir.yutao.coupon.entity.SeckillSkuNoticeEntity;
import com.ysir.yutao.coupon.service.SeckillSkuNoticeService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("seckillSkuNoticeService")
public class SeckillSkuNoticeServiceImpl extends ServiceImpl<SeckillSkuNoticeDao, SeckillSkuNoticeEntity> implements SeckillSkuNoticeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SeckillSkuNoticeEntity> page = this.page(
                new Query<SeckillSkuNoticeEntity>().getPage(params),
                new QueryWrapper<SeckillSkuNoticeEntity>()
        );

        return new PageUtils(page);
    }

}