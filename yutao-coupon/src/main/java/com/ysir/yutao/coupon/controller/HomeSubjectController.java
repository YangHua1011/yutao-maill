package com.ysir.yutao.coupon.controller;


import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.ResponseResult;
import com.ysir.yutao.coupon.entity.HomeSubjectEntity;
import com.ysir.yutao.coupon.service.HomeSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author 夏沫止水
 * @email HeJieLin@gulimall.com
 * @date 2020-05-22 19:35:30
 */
@RestController
@RequestMapping("coupon/homesubject")
public class HomeSubjectController {
    @Autowired
    private HomeSubjectService homeSubjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = homeSubjectService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		HomeSubjectEntity homeSubject = homeSubjectService.getById(id);

        return ResponseResult.ok().put("homeSubject", homeSubject);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public ResponseResult save(@RequestBody HomeSubjectEntity homeSubject){
		homeSubjectService.save(homeSubject);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody HomeSubjectEntity homeSubject){
		homeSubjectService.updateById(homeSubject);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		homeSubjectService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
