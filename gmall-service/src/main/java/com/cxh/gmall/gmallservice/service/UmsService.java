package com.cxh.gmall.gmallservice.service;

import com.cxh.gmall.gmallservice.bean.UmsMember;
import com.cxh.gmall.gmallservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UmsService
 *
 * @Author: 陈晓翰
 * @CreateTime: 2020-03-01
 * @Description:
 */
@Service
public class UmsService {

    @Autowired
    UserMapper userMapper;
    public List<UmsMember> getuser() {
        return userMapper.selectAll();
    }
}