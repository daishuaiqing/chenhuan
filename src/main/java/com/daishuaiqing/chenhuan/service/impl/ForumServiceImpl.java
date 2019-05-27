package com.daishuaiqing.chenhuan.service.impl;

import com.daishuaiqing.chenhuan.domain.Forum;
import com.daishuaiqing.chenhuan.dao.ForumDao;
import com.daishuaiqing.chenhuan.service.ForumService;
import com.daishuaiqing.chenhuan.query.ForumQuery;
import com.daishuaiqing.chenhuan.dto.ForumParam;
import com.daishuaiqing.chenhuan.vo.CommonResult;
import com.daishuaiqing.chenhuan.vo.ForumDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumDao forumDao;

    /**
    * forum 设置默认值
    * 创建时间，更新时间，是否删除
    * @param forum
    */
    private void setDefaultValue(Forum forum) {
        forum.setCreateTime(LocalDateTime.now());
        forum.setUpdateTime(LocalDateTime.now());
        forum.setDeleted(0);
    }

    @Override
    public ForumDetail findById(Long id) {
        ForumDetail forumDetail = new ForumDetail();
        Forum forum = forumDao.findById(id).orElse(null);
        forumDetail.setForum(forum);
        List<Forum> lastForum = forumDao.findLastForumById(id);
        List<Forum> nextForum = forumDao.findNextForumById(id);
        forumDetail.setLastForum(lastForum.size()>0?lastForum.get(0):null);
        forumDetail.setNextForum(nextForum.size()>0?nextForum.get(0):null);
        return forumDetail;
    }

    @Override
    public List<Forum> findAll() {
        return forumDao.findAll();
    }

    @Override
    public Forum add(ForumParam forumParam) {
        Forum forum = new Forum();
        BeanUtils.copyProperties(forumParam, forum);
        setDefaultValue(forum);
        return forumDao.save(forum);
    }

    @Override
    public Forum modify(ForumParam forumParam) {
        Forum data = forumDao.findById(forumParam.getId()).orElse(null);
        BeanUtils.copyProperties(forumParam, data);
        return forumDao.save(data);
    }

    @Override
    public Page<Forum> list(Pageable pageable,ForumQuery forumQuery) {
        Forum forum = new Forum();
        Example<Forum> example = Example.of(forum);
        return forumDao.findAll(example,pageable);
    }

    @Override
    public CommonResult deleteById(Long id) {
        forumDao.deleteById(id);
        return new CommonResult().success(!forumDao.existsById(id));
    }


}