package com.daishuaiqing.chenhuan.controller;

import com.daishuaiqing.chenhuan.authc.RequiresAuthc;
import com.daishuaiqing.chenhuan.dto.LinkParam;
import com.daishuaiqing.chenhuan.query.PageParam;
import com.daishuaiqing.chenhuan.service.LinkService;
import com.daishuaiqing.chenhuan.query.LinkQuery;
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
public class LinkController {

    @Autowired
    private LinkService linkService;

    @ApiOperation("单个查询")
    @GetMapping("/link/find/{id}")
    public CommonResult findById(@PathVariable("id") Long id){
        return new CommonResult().success(linkService.findById(id));
    }

    @ApiOperation("全部")
    @GetMapping("/link/find/all")
    public CommonResult findAll(){
        return new CommonResult().success(linkService.findAll());
    }

    @ApiOperation("新增")
    @RequiresAuthc
    @PostMapping("/link/add")
    public CommonResult add(@Valid @ApiParam @RequestBody LinkParam linkParam,
                            BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new CommonResult().validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }else {
            return new CommonResult().success(linkService.add(linkParam));
        }
    }

    @ApiOperation("删除")
    @RequiresAuthc
    @GetMapping("/link/delete/{id}")
    public CommonResult deleteById(@PathVariable("id") Long id) {
        return linkService.deleteById(id);
    }

    @ApiOperation("修改")
    @RequiresAuthc
    @PostMapping("/link/modify/{id}")
    public CommonResult modify(@PathVariable(name = "id",required = true) Long id,
                               @Valid @ApiParam @RequestBody LinkParam linkParam,
                               BindingResult bindingResult) {
        linkParam.setId(id);
        if(bindingResult.hasErrors()){
            return new CommonResult().validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }else {
            return new CommonResult().success(linkService.modify(linkParam));
        }
    }

    @ApiOperation("列表查询")
    @GetMapping("/link/list")
    public CommonResult list(PageParam page, LinkQuery linkQuery) {
        Pageable pageable = PageRequest.of(page.getPage(),page.getSize());
        return new CommonResult().success(linkService.list(pageable,linkQuery));
    }
}