package com.daishuaiqing.chenhuan.controller;

import com.daishuaiqing.chenhuan.dto.ForumParam;
import com.daishuaiqing.chenhuan.query.PageParam;
import com.daishuaiqing.chenhuan.service.ForumService;
import com.daishuaiqing.chenhuan.query.ForumQuery;
import com.daishuaiqing.chenhuan.vo.CommonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ForumController {

    @Autowired
    private ForumService forumService;

    @ApiOperation("单个查询")
    @GetMapping("/forum/find/{id}")
    public CommonResult findById(@PathVariable("id") Long id){
        return new CommonResult().success(forumService.findById(id));
    }

    @ApiOperation("全部")
    @GetMapping("/forum/find/all")
    public CommonResult findAll(){
        return new CommonResult().success(forumService.findAll());
    }

    @ApiOperation("新增")
    @PostMapping("/forum/add")
    public CommonResult add(@Valid @ApiParam @RequestBody ForumParam forumParam,
                            BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new CommonResult().validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }else {
            return new CommonResult().success(forumService.add(forumParam));
        }
    }

    @ApiOperation("删除")
    @GetMapping("/forum/delete/{id}")
    public CommonResult deleteById(@PathVariable("id") Long id) {
        return forumService.deleteById(id);
    }

    @ApiOperation("修改")
    @PostMapping("/forum/modify/{id}")
    public CommonResult modify(@PathVariable(name = "id",required = true) Long id,
                               @Valid @ApiParam @RequestBody ForumParam forumParam,
                               BindingResult bindingResult) {
        forumParam.setId(id);
        if(bindingResult.hasErrors()){
            return new CommonResult().validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }else {
            return new CommonResult().success(forumService.modify(forumParam));
        }
    }

    @ApiOperation("列表查询")
    @GetMapping("/forum/list")
    public CommonResult list(PageParam page, ForumQuery forumQuery) {
        Pageable pageable = PageRequest.of(page.getPage(),page.getSize());
        return new CommonResult().success(forumService.list(pageable,forumQuery));
    }
}