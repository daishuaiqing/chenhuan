package com.daishuaiqing.chenhuan.dao;

import com.daishuaiqing.chenhuan.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdminDao extends JpaRepository<Admin, Long>,JpaSpecificationExecutor<Admin> {
    Admin findByUsernameAndPassword(String username, String password);
}