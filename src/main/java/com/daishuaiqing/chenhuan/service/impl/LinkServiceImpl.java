package com.daishuaiqing.chenhuan.service.impl;

import com.daishuaiqing.chenhuan.domain.Link;
import com.daishuaiqing.chenhuan.dao.LinkDao;
import com.daishuaiqing.chenhuan.service.LinkService;
import com.daishuaiqing.chenhuan.query.LinkQuery;
import com.daishuaiqing.chenhuan.dto.LinkParam;
import com.daishuaiqing.chenhuan.vo.CommonResult;
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
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkDao linkDao;

    /**
    * link 设置默认值
    * 创建时间，更新时间，是否删除
    * @param link
    */
    private void setDefaultValue(Link link) {
        link.setCreateTime(LocalDateTime.now());
        link.setUpdateTime(LocalDateTime.now());
        link.setDeleted(0);
    }

    @Override
    public Link findById(Long id) {
        return linkDao.findById(id).orElse(null);
    }

    @Override
    public List<Link> findAll() {
        return linkDao.findAll();
    }

    @Override
    public Link add(LinkParam linkParam) {
        Link link = new Link();
        BeanUtils.copyProperties(linkParam, link);
        setDefaultValue(link);
        return linkDao.save(link);
    }

    @Override
    public Link modify(LinkParam linkParam) {
        Link data = linkDao.findById(linkParam.getId()).orElse(null);
        BeanUtils.copyProperties(linkParam, data);
        return linkDao.save(data);
    }

    @Override
    public Page<Link> list(Pageable pageable,LinkQuery linkQuery) {
        Link link = new Link();
        Example<Link> example = Example.of(link);
        return linkDao.findAll(example,pageable);
    }

    @Override
    public CommonResult deleteById(Long id) {
        linkDao.deleteById(id);
        return new CommonResult().success(!linkDao.existsById(id));
    }


}