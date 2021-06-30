package com.ysir.yutao.member.controller;

import java.util.Arrays;
import java.util.Map;

import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.ResponseResult;
import com.ysir.yutao.member.entity.MemberEntity;
import com.ysir.yutao.member.feign.CouponFeignService;
import com.ysir.yutao.member.feign.CouponFeignService;
import com.ysir.yutao.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * 会员
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-08 09:47:05
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    CouponFeignService couponFeignService;

    @RequestMapping("/coupons")
    public ResponseResult test(){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname("张三");

        ResponseResult membercoupons = couponFeignService.membercoupons();
        return ResponseResult.ok().put("mapper/member",memberEntity).put("coupons",membercoupons.get("coupons"));
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return ResponseResult.ok().put("mapper/member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody MemberEntity member){
		memberService.save(member);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
