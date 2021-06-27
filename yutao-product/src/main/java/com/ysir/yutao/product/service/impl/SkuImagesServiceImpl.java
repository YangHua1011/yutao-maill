package com.ysir.yutao.product.service.impl;

import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.Query;
import com.ysir.yutao.product.dao.SkuImagesDao;
import com.ysir.yutao.product.entity.SkuImagesEntity;
import com.ysir.yutao.product.service.SkuImagesService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("skuImagesService")
public class SkuImagesServiceImpl extends ServiceImpl<SkuImagesDao, SkuImagesEntity> implements SkuImagesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuImagesEntity> page = this.page(
                new Query<SkuImagesEntity>().getPage(params),
                new QueryWrapper<SkuImagesEntity>()
        );

        return new PageUtils(page);
    }

}