package com.daishuaiqing.chenhuan.controller;

import com.daishuaiqing.chenhuan.dto.CompanyInfoParam;
import com.daishuaiqing.chenhuan.query.PageParam;
import com.daishuaiqing.chenhuan.service.CompanyInfoService;
import com.daishuaiqing.chenhuan.query.CompanyInfoQuery;
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
public class CompanyInfoController {

    @Autowired
    private CompanyInfoService companyInfoService;

    @ApiOperation("单个查询")
    @GetMapping("/company_info/find/{id}")
    public CommonResult findById(@PathVariable("id") Long id){
        return new CommonResult().success(companyInfoService.findById(id));
    }

    @ApiOperation("全部")
    @GetMapping("/company_info/find/all")
    public CommonResult findAll(){
        return new CommonResult().success(companyInfoService.findAll());
    }

    @ApiOperation("新增")
    @PostMapping("/company_info/add")
    public CommonResult add(@Valid @ApiParam @RequestBody CompanyInfoParam companyInfoParam,
                            BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new CommonResult().validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }else {
            return new CommonResult().success(companyInfoService.add(companyInfoParam));
        }
    }

    @ApiOperation("删除")
    @GetMapping("/company_info/delete/{id}")
    public CommonResult deleteById(@PathVariable("id") Long id) {
        return companyInfoService.deleteById(id);
    }

    @ApiOperation("修改")
    @PostMapping("/company_info/modify/{id}")
    public CommonResult modify(@PathVariable(name = "id",required = true) Long id,
                               @Valid @ApiParam @RequestBody CompanyInfoParam companyInfoParam,
                               BindingResult bindingResult) {
        companyInfoParam.setId(id);
        if(bindingResult.hasErrors()){
            return new CommonResult().validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }else {
            return new CommonResult().success(companyInfoService.modify(companyInfoParam));
        }
    }

    @ApiOperation("列表查询")
    @GetMapping("/company_info/list")
    public CommonResult list(PageParam page, CompanyInfoQuery companyInfoQuery) {
        Pageable pageable = PageRequest.of(page.getPage(),page.getSize());
        return new CommonResult().success(companyInfoService.list(pageable,companyInfoQuery));
    }
}