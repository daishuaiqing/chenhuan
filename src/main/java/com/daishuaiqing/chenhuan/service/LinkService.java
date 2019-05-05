package com.daishuaiqing.chenhuan.service;

import com.daishuaiqing.chenhuan.domain.Link;
import com.daishuaiqing.chenhuan.query.LinkQuery;
import com.daishuaiqing.chenhuan.vo.CommonResult;
import com.daishuaiqing.chenhuan.dto.LinkParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LinkService {

    Link findById(Long id);

    List<Link> findAll();

    Link add(LinkParam linkParam);

    Link modify(LinkParam linkParam);

    Page<Link> list(Pageable pageable, LinkQuery linkQuery);

    CommonResult deleteById(Long id);

}