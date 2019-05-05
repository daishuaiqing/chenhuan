package com.daishuaiqing.chenhuan.dao;

import com.daishuaiqing.chenhuan.domain.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ForumDao extends JpaRepository<Forum, Long>,JpaSpecificationExecutor<Forum> {
 }