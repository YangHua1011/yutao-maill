package com.ysir.yutao.coupon.controller;


import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.ResponseResult;
import com.ysir.yutao.coupon.entity.HomeAdvEntity;
import com.ysir.yutao.coupon.service.HomeAdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 首页轮播广告
 *
 * @author 夏沫止水
 * @email HeJieLin@gulimall.com
 * @date 2020-05-22 19:35:30
 */
@RestController
@RequestMapping("coupon/homeadv")
public class HomeAdvController {
    @Autowired
    private HomeAdvService homeAdvService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = homeAdvService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		HomeAdvEntity homeAdv = homeAdvService.getById(id);

        return ResponseResult.ok().put("homeAdv", homeAdv);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody HomeAdvEntity homeAdv){
		homeAdvService.save(homeAdv);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody HomeAdvEntity homeAdv){
		homeAdvService.updateById(homeAdv);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		homeAdvService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
