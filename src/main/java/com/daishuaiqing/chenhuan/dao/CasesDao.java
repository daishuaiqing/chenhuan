package com.daishuaiqing.chenhuan.dao;

import com.daishuaiqing.chenhuan.domain.Cases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CasesDao extends JpaRepository<Cases, Long>,JpaSpecificationExecutor<Cases> {
    @Query(value = "SELECT * FROM `cases` WHERE `id`<?1 ORDER BY `id` DESC LIMIT 1",nativeQuery = true)
    List<Cases> findLastCasesById(Long id);

    @Query(value = "SELECT * FROM `cases` WHERE `id`>?1 ORDER BY `id` ASC LIMIT 1",nativeQuery = true)
    List<Cases> findNextCasesById(Long id);
}