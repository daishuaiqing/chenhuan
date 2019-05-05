package com.daishuaiqing.chenhuan.service;

import com.daishuaiqing.chenhuan.domain.Cases;
import com.daishuaiqing.chenhuan.query.CasesQuery;
import com.daishuaiqing.chenhuan.vo.CommonResult;
import com.daishuaiqing.chenhuan.dto.CasesParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CasesService {

    Cases findById(Long id);

    List<Cases> findAll();

    Cases add(CasesParam casesParam);

    Cases modify(CasesParam casesParam);

    Page<Cases> list(Pageable pageable, CasesQuery casesQuery);

    CommonResult deleteById(Long id);

}