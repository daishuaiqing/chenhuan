package com.daishuaiqing.chenhuan.service;

import com.daishuaiqing.chenhuan.domain.Admin;
import com.daishuaiqing.chenhuan.query.AdminQuery;
import com.daishuaiqing.chenhuan.vo.CommonResult;
import com.daishuaiqing.chenhuan.dto.AdminParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;

public interface AdminService {

    Admin findById(Long id);

    List<Admin> findAll();

    Admin add(AdminParam adminParam);

    CommonResult modify(AdminParam adminParam);

    Page<Admin> list(Pageable pageable, AdminQuery adminQuery);

    CommonResult deleteById(Long id);

    CommonResult login(AdminParam adminParam);
}