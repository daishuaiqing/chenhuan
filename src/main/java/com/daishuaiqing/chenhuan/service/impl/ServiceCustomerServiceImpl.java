package com.daishuaiqing.chenhuan.service.impl;

import com.daishuaiqing.chenhuan.domain.ServiceCustomer;
import com.daishuaiqing.chenhuan.dao.ServiceCustomerDao;
import com.daishuaiqing.chenhuan.service.ServiceCustomerService;
import com.daishuaiqing.chenhuan.query.ServiceCustomerQuery;
import com.daishuaiqing.chenhuan.dto.ServiceCustomerParam;
import com.daishuaiqing.chenhuan.vo.CommonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class ServiceCustomerServiceImpl implements ServiceCustomerService {

    @Autowired
    private ServiceCustomerDao serviceCustomerDao;

    /**
    * serviceCustomer 设置默认值
    * 创建时间，更新时间，是否删除
    * @param serviceCustomer
    */
    private void setDefaultValue(ServiceCustomer serviceCustomer) {
        serviceCustomer.setCreateTime(LocalDateTime.now());
        serviceCustomer.setUpdateTime(LocalDateTime.now());
        serviceCustomer.setDeleted(0);
    }

    @Override
    public ServiceCustomer findById(Long id) {
        return serviceCustomerDao.findById(id).orElse(null);
    }

    @Override
    public List<ServiceCustomer> findAll() {
        return serviceCustomerDao.findAll();
    }

    @Override
    public ServiceCustomer add(ServiceCustomerParam serviceCustomerParam) {
        ServiceCustomer serviceCustomer = new ServiceCustomer();
        BeanUtils.copyProperties(serviceCustomerParam, serviceCustomer);
        setDefaultValue(serviceCustomer);
        return serviceCustomerDao.save(serviceCustomer);
    }

    @Override
    public ServiceCustomer modify(ServiceCustomerParam serviceCustomerParam) {
        ServiceCustomer data = serviceCustomerDao.findById(serviceCustomerParam.getId()).orElse(null);
        BeanUtils.copyProperties(serviceCustomerParam, data);
        return serviceCustomerDao.save(data);
    }

    @Override
    public Page<ServiceCustomer> list(Pageable pageable,ServiceCustomerQuery serviceCustomerQuery) {
        ServiceCustomer serviceCustomer = new ServiceCustomer();
        Example<ServiceCustomer> example = Example.of(serviceCustomer);
        return serviceCustomerDao.findAll(example,pageable);
    }

    @Override
    public CommonResult deleteById(Long id) {
        serviceCustomerDao.deleteById(id);
        return new CommonResult().success(!serviceCustomerDao.existsById(id));
    }


}