package com.daishuaiqing.chenhuan.service;

import com.daishuaiqing.chenhuan.domain.CompanyInfo;
import com.daishuaiqing.chenhuan.query.CompanyInfoQuery;
import com.daishuaiqing.chenhuan.vo.CommonResult;
import com.daishuaiqing.chenhuan.dto.CompanyInfoParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyInfoService {

    CompanyInfo findById(Long id);

    List<CompanyInfo> findAll();

    CompanyInfo add(CompanyInfoParam companyInfoParam);

    CompanyInfo modify(CompanyInfoParam companyInfoParam);

    Page<CompanyInfo> list(Pageable pageable, CompanyInfoQuery companyInfoQuery);

    CommonResult deleteById(Long id);

}