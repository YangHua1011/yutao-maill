package com.ysir.yutao.product.controller;

import java.util.Arrays;
import java.util.Map;

import com.ysir.yutao.common.utils.PageUtils;
import com.ysir.yutao.common.utils.ResponseResult;
import com.ysir.yutao.product.entity.CommentReplayEntity;
import com.ysir.yutao.product.service.CommentReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * 商品评价回复关系
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-01 22:50:32
 */
@RestController
@RequestMapping("product/commentreplay")
public class CommentReplayController {
    @Autowired
    private CommentReplayService commentReplayService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = commentReplayService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		CommentReplayEntity commentReplay = commentReplayService.getById(id);

        return ResponseResult.ok().put("commentReplay", commentReplay);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody CommentReplayEntity commentReplay){
		commentReplayService.save(commentReplay);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody CommentReplayEntity commentReplay){
		commentReplayService.updateById(commentReplay);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		commentReplayService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
