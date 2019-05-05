package com.daishuaiqing.chenhuan.service;

import com.daishuaiqing.chenhuan.domain.ServiceCustomer;
import com.daishuaiqing.chenhuan.query.ServiceCustomerQuery;
import com.daishuaiqing.chenhuan.vo.CommonResult;
import com.daishuaiqing.chenhuan.dto.ServiceCustomerParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceCustomerService {

    ServiceCustomer findById(Long id);

    List<ServiceCustomer> findAll();

    ServiceCustomer add(ServiceCustomerParam serviceCustomerParam);

    ServiceCustomer modify(ServiceCustomerParam serviceCustomerParam);

    Page<ServiceCustomer> list(Pageable pageable, ServiceCustomerQuery serviceCustomerQuery);

    CommonResult deleteById(Long id);

}