package com.ysir.yutao.coupon.controller;


import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.ResponseResult;
import com.ysir.yutao.coupon.entity.MemberPriceEntity;
import com.ysir.yutao.coupon.service.MemberPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 商品会员价格
 *
 * @author 夏沫止水
 * @email HeJieLin@gulimall.com
 * @date 2020-05-22 19:35:30
 */
@RestController
@RequestMapping("coupon/memberprice")
public class MemberPriceController {
    @Autowired
    private MemberPriceService memberPriceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = memberPriceService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		MemberPriceEntity memberPrice = memberPriceService.getById(id);

        return ResponseResult.ok().put("memberPrice", memberPrice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody MemberPriceEntity memberPrice){
		memberPriceService.save(memberPrice);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody MemberPriceEntity memberPrice){
		memberPriceService.updateById(memberPrice);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		memberPriceService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
