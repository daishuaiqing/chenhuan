package com.daishuaiqing.chenhuan.service.impl;

import com.daishuaiqing.chenhuan.domain.CompanyInfo;
import com.daishuaiqing.chenhuan.dao.CompanyInfoDao;
import com.daishuaiqing.chenhuan.service.CompanyInfoService;
import com.daishuaiqing.chenhuan.query.CompanyInfoQuery;
import com.daishuaiqing.chenhuan.dto.CompanyInfoParam;
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
public class CompanyInfoServiceImpl implements CompanyInfoService {

    @Autowired
    private CompanyInfoDao companyInfoDao;

    /**
    * companyInfo 设置默认值
    * 创建时间，更新时间，是否删除
    * @param companyInfo
    */
    private void setDefaultValue(CompanyInfo companyInfo) {
        companyInfo.setCreateTime(LocalDateTime.now());
        companyInfo.setUpdateTime(LocalDateTime.now());
        companyInfo.setDeleted(0);
    }

    @Override
    public CompanyInfo findById(Long id) {
        return companyInfoDao.findById(id).orElse(null);
    }

    @Override
    public List<CompanyInfo> findAll() {
        return companyInfoDao.findAll();
    }

    @Override
    public CompanyInfo add(CompanyInfoParam companyInfoParam) {
        CompanyInfo companyInfo = new CompanyInfo();
        BeanUtils.copyProperties(companyInfoParam, companyInfo);
        setDefaultValue(companyInfo);
        return companyInfoDao.save(companyInfo);
    }

    @Override
    public CompanyInfo modify(CompanyInfoParam companyInfoParam) {
        CompanyInfo data = companyInfoDao.findById(companyInfoParam.getId()).orElse(null);
        return companyInfoDao.save(data);
    }

    @Override
    public Page<CompanyInfo> list(Pageable pageable,CompanyInfoQuery companyInfoQuery) {
        CompanyInfo companyInfo = new CompanyInfo();
        Example<CompanyInfo> example = Example.of(companyInfo);
        return companyInfoDao.findAll(example,pageable);
    }

    @Override
    public CommonResult deleteById(Long id) {
        companyInfoDao.deleteById(id);
        return new CommonResult().success(!companyInfoDao.existsById(id));
    }


}