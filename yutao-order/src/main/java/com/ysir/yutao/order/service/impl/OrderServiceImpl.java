package com.ysir.yutao.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.Query;
import com.ysir.yutao.order.dao.OrderDao;
import com.ysir.yutao.order.entity.OrderEntity;
import com.ysir.yutao.order.service.OrderService;
import org.springframework.stereotype.Service;
import java.util.Map;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderEntity> page = this.page(
                new Query<OrderEntity>().getPage(params),
                new QueryWrapper<OrderEntity>()
        );

        return new PageUtils(page);
    }

}