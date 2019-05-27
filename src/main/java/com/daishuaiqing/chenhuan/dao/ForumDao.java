package com.daishuaiqing.chenhuan.dao;

import com.daishuaiqing.chenhuan.domain.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ForumDao extends JpaRepository<Forum, Long>,JpaSpecificationExecutor<Forum> {
    @Query(value = "SELECT * FROM `forum` WHERE `id`<?1 and is_deleted=0 ORDER BY `id` DESC LIMIT 1",nativeQuery = true)
    List<Forum> findLastForumById(Long id);

    @Query(value = "SELECT * FROM `forum` WHERE `id`>?1 and is_deleted=0 ORDER BY `id` ASC LIMIT 1",nativeQuery = true)
    List<Forum> findNextForumById(Long id);
}