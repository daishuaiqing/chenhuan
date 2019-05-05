package com.daishuaiqing.chenhuan.dao;

import com.daishuaiqing.chenhuan.domain.RequesterInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RequesterInfoDao extends JpaRepository<RequesterInfo, Long>,JpaSpecificationExecutor<RequesterInfo> {
 }