package com.ysir.yutao.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysir.yutao.order.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-08 09:56:16
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
