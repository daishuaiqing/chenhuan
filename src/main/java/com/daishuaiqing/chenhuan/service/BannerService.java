package com.daishuaiqing.chenhuan.service;

import com.daishuaiqing.chenhuan.domain.Banner;
import com.daishuaiqing.chenhuan.dto.BannerParam;
import com.daishuaiqing.chenhuan.query.BannerQuery;
import com.daishuaiqing.chenhuan.vo.CommonResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BannerService {

    Banner findById(Long id);

    List<Banner> findAll();

    Banner add(BannerParam bannerParam);

    Banner modify(BannerParam bannerParam);

    Page<Banner> list(Pageable pageable, BannerQuery bannerQuery);

    CommonResult deleteById(Long id);

}