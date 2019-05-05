package com.daishuaiqing.chenhuan.dao;

import com.daishuaiqing.chenhuan.domain.Cases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CasesDao extends JpaRepository<Cases, Long>,JpaSpecificationExecutor<Cases> {
 }