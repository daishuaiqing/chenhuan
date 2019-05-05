package com.daishuaiqing.chenhuan.service.impl;

import com.daishuaiqing.chenhuan.domain.Cases;
import com.daishuaiqing.chenhuan.dao.CasesDao;
import com.daishuaiqing.chenhuan.service.CasesService;
import com.daishuaiqing.chenhuan.query.CasesQuery;
import com.daishuaiqing.chenhuan.dto.CasesParam;
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
public class CasesServiceImpl implements CasesService {

    @Autowired
    private CasesDao casesDao;

    /**
    * cases 设置默认值
    * 创建时间，更新时间，是否删除
    * @param cases
    */
    private void setDefaultValue(Cases cases) {
        cases.setCreateTime(LocalDateTime.now());
        cases.setUpdateTime(LocalDateTime.now());
        cases.setDeleted(0);
    }

    @Override
    public Cases findById(Long id) {
        return casesDao.findById(id).orElse(null);
    }

    @Override
    public List<Cases> findAll() {
        return casesDao.findAll();
    }

    @Override
    public Cases add(CasesParam casesParam) {
        Cases cases = new Cases();
        BeanUtils.copyProperties(casesParam, cases);
        setDefaultValue(cases);
        return casesDao.save(cases);
    }

    @Override
    public Cases modify(CasesParam casesParam) {
        Cases data = casesDao.findById(casesParam.getId()).orElse(null);
        return casesDao.save(data);
    }

    @Override
    public Page<Cases> list(Pageable pageable,CasesQuery casesQuery) {
        Cases cases = new Cases();
        Example<Cases> example = Example.of(cases);
        return casesDao.findAll(example,pageable);
    }

    @Override
    public CommonResult deleteById(Long id) {
        casesDao.deleteById(id);
        return new CommonResult().success(!casesDao.existsById(id));
    }


}