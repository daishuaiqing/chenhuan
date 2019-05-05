package com.daishuaiqing.chenhuan.dao;

import com.daishuaiqing.chenhuan.domain.ServiceCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ServiceCustomerDao extends JpaRepository<ServiceCustomer, Long>,JpaSpecificationExecutor<ServiceCustomer> {
 }