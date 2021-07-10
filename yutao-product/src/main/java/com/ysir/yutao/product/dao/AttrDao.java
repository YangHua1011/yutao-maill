package com.ysir.yutao.product.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysir.yutao.product.entity.AttrEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品属性
 * 
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-01 21:08:49
 */
public interface AttrDao extends BaseMapper<AttrEntity> {

    List<Long> selectSearchAttrIds(List<Long> attrIds);
}
