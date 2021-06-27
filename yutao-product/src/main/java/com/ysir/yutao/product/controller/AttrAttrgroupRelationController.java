package com.ysir.yutao.product.controller;

import java.util.Arrays;
import java.util.Map;

import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.ResponseResult;
import com.ysir.yutao.product.entity.AttrAttrgroupRelationEntity;
import com.ysir.yutao.product.service.AttrAttrgroupRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * 属性&属性分组关联
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-01 22:50:32
 */
@RestController
@RequestMapping("product/attrattrgrouprelation")
public class AttrAttrgroupRelationController {
    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = attrAttrgroupRelationService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		AttrAttrgroupRelationEntity attrAttrgroupRelation = attrAttrgroupRelationService.getById(id);

        return ResponseResult.ok().put("attrAttrgroupRelation", attrAttrgroupRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody AttrAttrgroupRelationEntity attrAttrgroupRelation){
		attrAttrgroupRelationService.save(attrAttrgroupRelation);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody AttrAttrgroupRelationEntity attrAttrgroupRelation){
		attrAttrgroupRelationService.updateById(attrAttrgroupRelation);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		attrAttrgroupRelationService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
