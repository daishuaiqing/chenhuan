package com.daishuaiqing.chenhuan.controller;

import com.daishuaiqing.chenhuan.dto.ServiceCustomerParam;
import com.daishuaiqing.chenhuan.query.PageParam;
import com.daishuaiqing.chenhuan.service.ServiceCustomerService;
import com.daishuaiqing.chenhuan.query.ServiceCustomerQuery;
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
public class ServiceCustomerController {

    @Autowired
    private ServiceCustomerService serviceCustomerService;

    @ApiOperation("单个查询")
    @GetMapping("/service_customer/find/{id}")
    public CommonResult findById(@PathVariable("id") Long id){
        return new CommonResult().success(serviceCustomerService.findById(id));
    }

    @ApiOperation("全部")
    @GetMapping("/service_customer/find/all")
    public CommonResult findAll(){
        return new CommonResult().success(serviceCustomerService.findAll());
    }

    @ApiOperation("新增")
    @PostMapping("/service_customer/add")
    public CommonResult add(@Valid @ApiParam @RequestBody ServiceCustomerParam serviceCustomerParam,
                            BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new CommonResult().validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }else {
            return new CommonResult().success(serviceCustomerService.add(serviceCustomerParam));
        }
    }

    @ApiOperation("删除")
    @GetMapping("/service_customer/delete/{id}")
    public CommonResult deleteById(@PathVariable("id") Long id) {
        return serviceCustomerService.deleteById(id);
    }

    @ApiOperation("修改")
    @PostMapping("/service_customer/modify/{id}")
    public CommonResult modify(@PathVariable(name = "id",required = true) Long id,
                               @Valid @ApiParam @RequestBody ServiceCustomerParam serviceCustomerParam,
                               BindingResult bindingResult) {
        serviceCustomerParam.setId(id);
        if(bindingResult.hasErrors()){
            return new CommonResult().validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }else {
            return new CommonResult().success(serviceCustomerService.modify(serviceCustomerParam));
        }
    }

    @ApiOperation("列表查询")
    @GetMapping("/service_customer/list")
    public CommonResult list(PageParam page, ServiceCustomerQuery serviceCustomerQuery) {
        Pageable pageable = PageRequest.of(page.getPage(),page.getSize());
        return new CommonResult().success(serviceCustomerService.list(pageable,serviceCustomerQuery));
    }
}