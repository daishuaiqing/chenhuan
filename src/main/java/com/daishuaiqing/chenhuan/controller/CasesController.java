package com.daishuaiqing.chenhuan.controller;

import com.daishuaiqing.chenhuan.authc.RequiresAuthc;
import com.daishuaiqing.chenhuan.dto.CasesParam;
import com.daishuaiqing.chenhuan.query.PageParam;
import com.daishuaiqing.chenhuan.service.CasesService;
import com.daishuaiqing.chenhuan.query.CasesQuery;
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
public class CasesController {

    @Autowired
    private CasesService casesService;

    @ApiOperation("单个查询")
    @GetMapping("/cases/find/{id}")
    public CommonResult findById(@PathVariable("id") Long id){
        return new CommonResult().success(casesService.findById(id));
    }

    @ApiOperation("全部")
    @GetMapping("/cases/find/all")
    public CommonResult findAll(){
        return new CommonResult().success(casesService.findAll());
    }

    @ApiOperation("新增")
    @RequiresAuthc
    @PostMapping("/cases/add")
    public CommonResult add(@Valid @ApiParam @RequestBody CasesParam casesParam,
                            BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new CommonResult().validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }else {
            return new CommonResult().success(casesService.add(casesParam));
        }
    }

    @ApiOperation("删除")
    @RequiresAuthc
    @GetMapping("/cases/delete/{id}")
    public CommonResult deleteById(@PathVariable("id") Long id) {
        return casesService.deleteById(id);
    }

    @ApiOperation("修改")
    @RequiresAuthc
    @PostMapping("/cases/modify/{id}")
    public CommonResult modify(@PathVariable(name = "id",required = true) Long id,
                               @Valid @ApiParam @RequestBody CasesParam casesParam,
                               BindingResult bindingResult) {
        casesParam.setId(id);
        if(bindingResult.hasErrors()){
            return new CommonResult().validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }else {
            return new CommonResult().success(casesService.modify(casesParam));
        }
    }

    @ApiOperation("列表查询")
    @GetMapping("/cases/list")
    public CommonResult list(PageParam page, CasesQuery casesQuery) {
        Pageable pageable = PageRequest.of(page.getPage(),page.getSize());
        return new CommonResult().success(casesService.list(pageable,casesQuery));
    }
}