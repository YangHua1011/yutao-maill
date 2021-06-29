package com.ysir.yutao.product.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author ZSY
 * @createTime: 2020-06-19 11:21
 */
@Data
@ToString
public class SkuItemSaleAttrVo {

    private Long attrId;

    private String attrName;

    private List<AttrValueWithSkuIdVo> attrValues;

}
