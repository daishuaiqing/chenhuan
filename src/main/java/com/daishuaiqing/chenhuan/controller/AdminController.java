package com.daishuaiqing.chenhuan.controller;

import com.daishuaiqing.chenhuan.dto.AdminParam;
import com.daishuaiqing.chenhuan.query.PageParam;
import com.daishuaiqing.chenhuan.service.AdminService;
import com.daishuaiqing.chenhuan.query.AdminQuery;
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
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation("单个查询")
    @GetMapping("/admin/find/{id}")
    public CommonResult findById(@PathVariable("id") Long id){
        return new CommonResult().success(adminService.findById(id));
    }

    @ApiOperation("全部")
    @GetMapping("/admin/find/all")
    public CommonResult findAll(){
        return new CommonResult().success(adminService.findAll());
    }

    @ApiOperation("新增")
    @PostMapping("/admin/add")
    public CommonResult add(@Valid @ApiParam @RequestBody AdminParam adminParam,
                            BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new CommonResult().validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }else {
            return new CommonResult().success(adminService.add(adminParam));
        }
    }

    @ApiOperation("删除")
    @GetMapping("/admin/delete/{id}")
    public CommonResult deleteById(@PathVariable("id") Long id) {
        return adminService.deleteById(id);
    }

    @ApiOperation("修改")
    @PostMapping("/admin/modify/{id}")
    public CommonResult modify(@PathVariable(name = "id",required = true) Long id,
                               @Valid @ApiParam @RequestBody AdminParam adminParam,
                               BindingResult bindingResult) {
        adminParam.setId(id);
        if(bindingResult.hasErrors()){
            return new CommonResult().validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }else {
            return adminService.modify(adminParam);
        }
    }

    @ApiOperation("列表查询")
    @GetMapping("/admin/list")
    public CommonResult list(PageParam page, AdminQuery adminQuery) {
        Pageable pageable = PageRequest.of(page.getPage(),page.getSize());
        return new CommonResult().success(adminService.list(pageable,adminQuery));
    }

    @ApiOperation("用户登录")
    @PostMapping("/admin/login")
    public CommonResult login(@Valid @ApiParam @RequestBody AdminParam adminParam,
                              BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new CommonResult().validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }else {
            return adminService.login(adminParam);
        }
    }
}