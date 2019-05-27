package com.daishuaiqing.chenhuan.service;

import com.daishuaiqing.chenhuan.domain.Forum;
import com.daishuaiqing.chenhuan.query.ForumQuery;
import com.daishuaiqing.chenhuan.vo.CommonResult;
import com.daishuaiqing.chenhuan.dto.ForumParam;
import com.daishuaiqing.chenhuan.vo.ForumDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ForumService {

    ForumDetail findById(Long id);

    List<Forum> findAll();

    Forum add(ForumParam forumParam);

    Forum modify(ForumParam forumParam);

    Page<Forum> list(Pageable pageable, ForumQuery forumQuery);

    CommonResult deleteById(Long id);

}