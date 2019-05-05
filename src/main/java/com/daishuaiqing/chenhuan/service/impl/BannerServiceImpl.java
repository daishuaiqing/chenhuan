package com.daishuaiqing.chenhuan.service.impl;

import com.daishuaiqing.chenhuan.domain.Banner;
import com.daishuaiqing.chenhuan.dao.BannerDao;
import com.daishuaiqing.chenhuan.dto.BannerParam;
import com.daishuaiqing.chenhuan.service.BannerService;
import com.daishuaiqing.chenhuan.query.BannerQuery;
import com.daishuaiqing.chenhuan.vo.CommonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    /**
    * banner 设置默认值
    * 创建时间，更新时间，是否删除
    * @param banner
    */
    private void setDefaultValue(Banner banner) {
        banner.setCreateTime(LocalDateTime.now());
        banner.setUpdateTime(LocalDateTime.now());
        banner.setDeleted(0);
    }

    @Override
    public Banner findById(Long id) {
        return bannerDao.findById(id).orElse(null);
    }

    @Override
    public List<Banner> findAll() {
        return bannerDao.findAll();
    }

    @Override
    public Banner add(BannerParam bannerParam) {
        Banner banner = new Banner();
        BeanUtils.copyProperties(bannerParam, banner);
        setDefaultValue(banner);
        return bannerDao.save(banner);
    }

    @Override
    public Banner modify(BannerParam bannerParam) {
        Banner data = bannerDao.findById(bannerParam.getId()).orElse(null);
        return bannerDao.save(data);
    }

    @Override
    public Page<Banner> list(Pageable pageable, BannerQuery bannerQuery) {
        Banner banner = new Banner();
        Example<Banner> example = Example.of(banner);
        return bannerDao.findAll(example,pageable);
    }

    @Override
    public CommonResult deleteById(Long id) {
        bannerDao.deleteById(id);
        return new CommonResult().success(!bannerDao.existsById(id));
    }


}