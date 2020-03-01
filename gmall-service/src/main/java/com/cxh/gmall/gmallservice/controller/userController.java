package com.cxh.gmall.gmallservice.controller;

import com.cxh.gmall.gmallservice.bean.UmsMember;
import com.cxh.gmall.gmallservice.service.UmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * userController
 *
 * @Author: 陈晓翰
 * @CreateTime: 2020-03-01
 * @Description:
 */
@RestController
public class userController {
    @Autowired
    private UmsService umsService;
    @RequestMapping("/user")
    public List<UmsMember> user(){
        List<UmsMember> umsMembers = umsService.getuser();
        return umsMembers;
    }
}