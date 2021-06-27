package com.ysir.yutao.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.ResponseResult;
import com.ysir.yutao.product.entity.AttrEntity;
import com.ysir.yutao.product.entity.AttrGroupEntity;
import com.ysir.yutao.product.service.AttrAttrgroupRelationService;
import com.ysir.yutao.product.service.AttrGroupService;
import com.ysir.yutao.product.service.AttrService;
import com.ysir.yutao.product.service.CategoryService;
import com.ysir.yutao.product.vo.AttrGroupRelationVo;
import com.ysir.yutao.product.vo.AttrGroupWithAttrsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




/**
 * 属性分组
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-01 22:50:32
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    AttrService attrService;

    @Autowired
    AttrAttrgroupRelationService relationService;

    ///product/attrgroup/attr/relation
    @PostMapping("/attr/relation")
    public ResponseResult addRelation(@RequestBody List<AttrGroupRelationVo> vos){

        relationService.saveBatch(vos);
        return ResponseResult.ok();
    }

    ///product/attrgroup/{catelogId}/withattr
    @GetMapping("/{catelogId}/withattr")
    public ResponseResult getAttrGroupWithAttrs(@PathVariable("catelogId")Long catelogId){

        //1、查出当前分类下的所有属性分组，
        //2、查出每个属性分组的所有属性
       List<AttrGroupWithAttrsVo> vos =  attrGroupService.getAttrGroupWithAttrsByCatelogId(catelogId);
       return ResponseResult.ok().put("data",vos);
    }


    ///product/attrgroup/{attrgroupId}/attr/relation
    @GetMapping("/{attrgroupId}/attr/relation")
    public ResponseResult attrRelation(@PathVariable("attrgroupId") Long attrgroupId){
        List<AttrEntity> entities =  attrService.getRelationAttr(attrgroupId);
        return ResponseResult.ok().put("data",entities);
    }

    ///product/attrgroup/{attrgroupId}/noattr/relation
    @GetMapping("/{attrgroupId}/noattr/relation")
    public ResponseResult attrNoRelation(@PathVariable("attrgroupId") Long attrgroupId,
                            @RequestParam Map<String, Object> params){
        PageUtils page = attrService.getNoRelationAttr(params,attrgroupId);
        return ResponseResult.ok().put("page",page);
    }

    @PostMapping("/attr/relation/delete")
    public ResponseResult deleteRelation(@RequestBody  AttrGroupRelationVo[] vos){
        attrService.deleteRelation(vos);
        return ResponseResult.ok();
    }

    /**
     * 列表
     */
    @RequestMapping("/list/{catelogId}")
    public ResponseResult list(@RequestParam Map<String, Object> params,
                  @PathVariable("catelogId") Long catelogId){
//        PageUtils page = attrGroupService.queryPage(params);

        PageUtils page = attrGroupService.queryPage(params,catelogId);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    public ResponseResult info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);

        Long catelogId = attrGroup.getCatelogId();
        Long[] path = categoryService.findCatelogPath(catelogId);

        attrGroup.setCatelogPath(path);

        return ResponseResult.ok().put("attrGroup", attrGroup);
    }



    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return ResponseResult.ok();
    }

}
