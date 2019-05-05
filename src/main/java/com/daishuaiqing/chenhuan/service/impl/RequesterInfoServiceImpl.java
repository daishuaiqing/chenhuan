package com.daishuaiqing.chenhuan.service.impl;

import com.daishuaiqing.chenhuan.domain.RequesterInfo;
import com.daishuaiqing.chenhuan.dao.RequesterInfoDao;
import com.daishuaiqing.chenhuan.service.RequesterInfoService;
import com.daishuaiqing.chenhuan.query.RequesterInfoQuery;
import com.daishuaiqing.chenhuan.dto.RequesterInfoParam;
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
public class RequesterInfoServiceImpl implements RequesterInfoService {

    @Autowired
    private RequesterInfoDao requesterInfoDao;

    /**
    * requesterInfo 设置默认值
    * 创建时间，更新时间，是否删除
    * @param requesterInfo
    */
    private void setDefaultValue(RequesterInfo requesterInfo) {
        requesterInfo.setCreateTime(LocalDateTime.now());
        requesterInfo.setUpdateTime(LocalDateTime.now());
        requesterInfo.setDeleted(0);
    }

    @Override
    public RequesterInfo findById(Long id) {
        return requesterInfoDao.findById(id).orElse(null);
    }

    @Override
    public List<RequesterInfo> findAll() {
        return requesterInfoDao.findAll();
    }

    @Override
    public RequesterInfo add(RequesterInfoParam requesterInfoParam) {
        RequesterInfo requesterInfo = new RequesterInfo();
        BeanUtils.copyProperties(requesterInfoParam, requesterInfo);
        setDefaultValue(requesterInfo);
        return requesterInfoDao.save(requesterInfo);
    }

    @Override
    public RequesterInfo modify(RequesterInfoParam requesterInfoParam) {
        RequesterInfo data = requesterInfoDao.findById(requesterInfoParam.getId()).orElse(null);
        return requesterInfoDao.save(data);
    }

    @Override
    public Page<RequesterInfo> list(Pageable pageable,RequesterInfoQuery requesterInfoQuery) {
        RequesterInfo requesterInfo = new RequesterInfo();
        Example<RequesterInfo> example = Example.of(requesterInfo);
        return requesterInfoDao.findAll(example,pageable);
    }

    @Override
    public CommonResult deleteById(Long id) {
        requesterInfoDao.deleteById(id);
        return new CommonResult().success(!requesterInfoDao.existsById(id));
    }


}