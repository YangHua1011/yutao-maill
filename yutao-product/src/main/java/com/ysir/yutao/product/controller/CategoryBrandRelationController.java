package com.ysir.yutao.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.ResponseResult;
import com.ysir.yutao.product.entity.BrandEntity;
import com.ysir.yutao.product.entity.CategoryBrandRelationEntity;
import com.ysir.yutao.product.service.CategoryBrandRelationService;
import com.ysir.yutao.product.vo.BrandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




/**
 * 品牌分类关联
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-11-17 21:25:25
 */
@RestController
@RequestMapping("product/categorybrandrelation")
public class CategoryBrandRelationController {
    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    /**
     * 获取当前品牌关联的所有分类列表
     */
    @GetMapping("/catelog/list")
    public ResponseResult cateloglist(@RequestParam("brandId")Long brandId){
        List<CategoryBrandRelationEntity> data = categoryBrandRelationService.list(
                new QueryWrapper<CategoryBrandRelationEntity>().eq("brand_id",brandId)
        );

        return ResponseResult.ok().put("data", data);
    }

    /**
     *  /product/categorybrandrelation/brands/list
     *
     *  1、Controller：处理请求，接受和校验数据
     *  2、Service接受controller传来的数据，进行业务处理
     *  3、Controller接受Service处理完的数据，封装页面指定的vo
     */
    @GetMapping("/brands/list")
    public ResponseResult relationBrandsList(@RequestParam(value = "catId",required = true)Long catId){
        List<BrandEntity> vos = categoryBrandRelationService.getBrandsByCatId(catId);

        List<BrandVo> collect = vos.stream().map(item -> {
            BrandVo brandVo = new BrandVo();
            brandVo.setBrandId(item.getBrandId());
            brandVo.setBrandName(item.getName());

            return brandVo;
        }).collect(Collectors.toList());

        return ResponseResult.ok().put("data",collect);

    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryBrandRelationService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);

        return ResponseResult.ok().put("categoryBrandRelation", categoryBrandRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){


		categoryBrandRelationService.saveDetail(categoryBrandRelation);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
		categoryBrandRelationService.updateById(categoryBrandRelation);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		categoryBrandRelationService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
