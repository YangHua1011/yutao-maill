package com.ysir.yutao.order.service.impl;

import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.Query;
import com.ysir.yutao.order.dao.OrderReturnApplyDao;
import com.ysir.yutao.order.entity.OrderReturnApplyEntity;
import com.ysir.yutao.order.service.OrderReturnApplyService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("orderReturnApplyService")
public class OrderReturnApplyServiceImpl extends ServiceImpl<OrderReturnApplyDao, OrderReturnApplyEntity> implements OrderReturnApplyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderReturnApplyEntity> page = this.page(
                new Query<OrderReturnApplyEntity>().getPage(params),
                new QueryWrapper<OrderReturnApplyEntity>()
        );

        return new PageUtils(page);
    }

}