package com.daishuaiqing.chenhuan.dao;

import com.daishuaiqing.chenhuan.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LinkDao extends JpaRepository<Link, Long>,JpaSpecificationExecutor<Link> {
 }