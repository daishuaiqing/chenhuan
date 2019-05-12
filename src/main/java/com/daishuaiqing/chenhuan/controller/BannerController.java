package com.daishuaiqing.chenhuan.controller;

import com.daishuaiqing.chenhuan.authc.RequiresAuthc;
import com.daishuaiqing.chenhuan.dto.BannerParam;
import com.daishuaiqing.chenhuan.query.PageParam;
import com.daishuaiqing.chenhuan.service.BannerService;
import com.daishuaiqing.chenhuan.query.BannerQuery;
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
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @ApiOperation("单个查询")
    @GetMapping("/banner/find/{id}")
    public CommonResult findById(@PathVariable("id") Long id){
        return new CommonResult().success(bannerService.findById(id));
    }

    @ApiOperation("全部")
    @GetMapping("/banner/find/all")
    public CommonResult findAll(){
        return new CommonResult().success(bannerService.findAll());
    }

    @ApiOperation("新增")
    @RequiresAuthc
    @PostMapping("/banner/add")
    public CommonResult add(@Valid @ApiParam @RequestBody BannerParam bannerParam,
                            BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new CommonResult().validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }else {
            return new CommonResult().success(bannerService.add(bannerParam));
        }
    }

    @ApiOperation("删除")
    @RequiresAuthc
    @GetMapping("/banner/delete/{id}")
    public CommonResult deleteById(@PathVariable("id") Long id) {
        return bannerService.deleteById(id);
    }

    @ApiOperation("修改")
    @RequiresAuthc
    @PostMapping("/banner/modify/{id}")
    public CommonResult modify(@PathVariable(name = "id",required = true) Long id,
                               @Valid @ApiParam @RequestBody BannerParam bannerParam,
                               BindingResult bindingResult) {
        bannerParam.setId(id);
        if(bindingResult.hasErrors()){
            return new CommonResult().validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }else {
            return new CommonResult().success(bannerService.modify(bannerParam));
        }
    }

    @ApiOperation("列表查询")
    @GetMapping("/banner/list")
    public CommonResult list(PageParam page, BannerQuery bannerQuery) {
        Pageable pageable = PageRequest.of(page.getPage(),page.getSize());
        return new CommonResult().success(bannerService.list(pageable,bannerQuery));
    }
}