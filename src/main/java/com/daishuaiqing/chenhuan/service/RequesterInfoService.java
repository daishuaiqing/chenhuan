package com.daishuaiqing.chenhuan.service;

import com.daishuaiqing.chenhuan.domain.RequesterInfo;
import com.daishuaiqing.chenhuan.query.RequesterInfoQuery;
import com.daishuaiqing.chenhuan.vo.CommonResult;
import com.daishuaiqing.chenhuan.dto.RequesterInfoParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RequesterInfoService {

    RequesterInfo findById(Long id);

    List<RequesterInfo> findAll();

    RequesterInfo add(RequesterInfoParam requesterInfoParam);

    RequesterInfo modify(RequesterInfoParam requesterInfoParam);

    Page<RequesterInfo> list(Pageable pageable, RequesterInfoQuery requesterInfoQuery);

    CommonResult deleteById(Long id);

}