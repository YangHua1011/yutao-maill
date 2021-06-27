package com.ysir.yutao.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.ResponseResult;
import com.ysir.yutao.product.entity.ProductAttrValueEntity;
import com.ysir.yutao.product.service.AttrService;
import com.ysir.yutao.product.service.ProductAttrValueService;
import com.ysir.yutao.product.vo.AttrRespVo;
import com.ysir.yutao.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




/**
 * 商品属性
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-01 22:50:32
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @Autowired
    ProductAttrValueService productAttrValueService;

    ///product/attr/info/{attrId}

    // /product/attr/base/listforspu/{spuId}
    @GetMapping("/base/listforspu/{spuId}")
    public ResponseResult baseAttrlistforspu(@PathVariable("spuId") Long spuId){

        List<ProductAttrValueEntity> entities = productAttrValueService.baseAttrlistforspu(spuId);

        return ResponseResult.ok().put("data",entities);
    }

    //product/attr/sale/list/0?
    ///product/attr/base/list/{catelogId}
    @GetMapping("/{attrType}/list/{catelogId}")
    public ResponseResult baseAttrList(@RequestParam Map<String, Object> params,
                          @PathVariable("catelogId") Long catelogId,
                          @PathVariable("attrType")String type){

        PageUtils page = attrService.queryBaseAttrPage(params,catelogId,type);
        return ResponseResult.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attr:list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    //@RequiresPermissions("product:attr:info")
    public ResponseResult info(@PathVariable("attrId") Long attrId){
		//AttrEntity attr = attrService.getById(attrId);
        AttrRespVo respVo = attrService.getAttrInfo(attrId);

        return ResponseResult.ok().put("attr", respVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attr:save")
    public ResponseResult save(@RequestBody AttrVo attr){
		attrService.saveAttr(attr);

        return ResponseResult.ok();
    }

    ///product/attrgroup/attr/relation/delete


    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attr:update")
    public ResponseResult update(@RequestBody AttrVo attr){
		attrService.updateAttr(attr);

        return ResponseResult.ok();
    }

    ///product/attr/update/{spuId}
    @PostMapping("/update/{spuId}")
    public ResponseResult updateSpuAttr(@PathVariable("spuId") Long spuId,
                                        @RequestBody List<ProductAttrValueEntity> entities){

        productAttrValueService.updateSpuAttr(spuId,entities);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attr:delete")
    public ResponseResult delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return ResponseResult.ok();
    }

}
