package com.daishuaiqing.chenhuan.dao;

import com.daishuaiqing.chenhuan.domain.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BannerDao extends JpaRepository<Banner, Long>,JpaSpecificationExecutor<Banner> {
 }