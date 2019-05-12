package com.daishuaiqing.chenhuan.service.impl;

import com.daishuaiqing.chenhuan.cache.LocalCache;
import com.daishuaiqing.chenhuan.domain.Admin;
import com.daishuaiqing.chenhuan.dao.AdminDao;
import com.daishuaiqing.chenhuan.service.AdminService;
import com.daishuaiqing.chenhuan.query.AdminQuery;
import com.daishuaiqing.chenhuan.dto.AdminParam;
import com.daishuaiqing.chenhuan.util.Md5Utils;
import com.daishuaiqing.chenhuan.vo.CommonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;
    @Autowired
    private LocalCache localCache;
    /**
     * 有效时间
     * 1天
     */
    private Integer expireTime = 60*60*24;

    /**
    * admin 设置默认值
    * 创建时间，更新时间，是否删除
    * @param admin
    */
    private void setDefaultValue(Admin admin) {
        admin.setCreateTime(LocalDateTime.now());
        admin.setUpdateTime(LocalDateTime.now());
        admin.setDeleted(0);
    }

    @Override
    public Admin findById(Long id) {
        return adminDao.findById(id).orElse(null);
    }

    @Override
    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    @Override
    public Admin add(AdminParam adminParam) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminParam, admin);
        setDefaultValue(admin);
        admin.setPassword(Md5Utils.getMD5(admin.getPassword()));//密码转MD5加密字符串
        return adminDao.save(admin);
    }

    @Override
    public CommonResult modify(AdminParam adminParam) {
        Admin data = adminDao.findById(adminParam.getId()).orElse(null);
        if(data != null){
            data.setPassword(Md5Utils.getMD5(adminParam.getPassword()));
            return new CommonResult().success(adminDao.save(data));
        }else {
            return new CommonResult().validateFailed("不存在此账户");
        }
    }

    @Override
    public Page<Admin> list(Pageable pageable,AdminQuery adminQuery) {
        Admin admin = new Admin();
        Example<Admin> example = Example.of(admin);
        return adminDao.findAll(example,pageable);
    }

    @Override
    public CommonResult deleteById(Long id) {
        adminDao.deleteById(id);
        return new CommonResult().success(!adminDao.existsById(id));
    }

    /**
     * 用户登陆
     * @param adminParam
     * @return
     */
    @Override
    public CommonResult login(@Valid AdminParam adminParam) {
        Admin result = adminDao.findByUsernameAndPassword(adminParam.getUsername(),Md5Utils.getMD5(adminParam.getPassword()));
        if(result != null){
            String token = UUID.randomUUID().toString();
            localCache.putValue(token,result,expireTime);
            return new CommonResult().success(token);
        }else{
            return new CommonResult().validateFailed("账号或密码错误");
        }
    }


}