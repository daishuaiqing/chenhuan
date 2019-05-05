package com.daishuaiqing.chenhuan.controller;

import com.daishuaiqing.chenhuan.dto.RequesterInfoParam;
import com.daishuaiqing.chenhuan.query.PageParam;
import com.daishuaiqing.chenhuan.service.RequesterInfoService;
import com.daishuaiqing.chenhuan.query.RequesterInfoQuery;
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
public class RequesterInfoController {

    @Autowired
    private RequesterInfoService requesterInfoService;

    @ApiOperation("单个查询")
    @GetMapping("/requester_info/find/{id}")
    public CommonResult findById(@PathVariable("id") Long id){
        return new CommonResult().success(requesterInfoService.findById(id));
    }

    @ApiOperation("全部")
    @GetMapping("/requester_info/find/all")
    public CommonResult findAll(){
        return new CommonResult().success(requesterInfoService.findAll());
    }

    @ApiOperation("新增")
    @PostMapping("/requester_info/add")
    public CommonResult add(@Valid @ApiParam @RequestBody RequesterInfoParam requesterInfoParam,
                            BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new CommonResult().validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }else {
            return new CommonResult().success(requesterInfoService.add(requesterInfoParam));
        }
    }

    @ApiOperation("删除")
    @GetMapping("/requester_info/delete/{id}")
    public CommonResult deleteById(@PathVariable("id") Long id) {
        return requesterInfoService.deleteById(id);
    }

    @ApiOperation("修改")
    @PostMapping("/requester_info/modify/{id}")
    public CommonResult modify(@PathVariable(name = "id",required = true) Long id,
                               @Valid @ApiParam @RequestBody RequesterInfoParam requesterInfoParam,
                               BindingResult bindingResult) {
        requesterInfoParam.setId(id);
        if(bindingResult.hasErrors()){
            return new CommonResult().validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }else {
            return new CommonResult().success(requesterInfoService.modify(requesterInfoParam));
        }
    }

    @ApiOperation("列表查询")
    @GetMapping("/requester_info/list")
    public CommonResult list(PageParam page, RequesterInfoQuery requesterInfoQuery) {
        Pageable pageable = PageRequest.of(page.getPage(),page.getSize());
        return new CommonResult().success(requesterInfoService.list(pageable,requesterInfoQuery));
    }
}