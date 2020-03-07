package com.cxh.gmall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cxh.gmall.bean.PmsBaseAttrInfo;
import com.cxh.gmall.bean.PmsBaseSaleAttr;
import com.cxh.gmall.service.AttrService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * AttrController
 *
 * @Author: 陈晓翰
 * @CreateTime: 2020-03-03
 * @Description:
 */
@RestController
@CrossOrigin
public class AttrController {
    @Reference
    AttrService attrService;
    // attrInfoList?catalog3Id=61
    @RequestMapping("attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){
        List<PmsBaseAttrInfo> pmsBaseAttrInfos=attrService.attrInfoList(catalog3Id);
        return pmsBaseAttrInfos;
    }
// saveAttrInfo:1 Failed to load resource
    @RequestMapping("saveAttrInfo")
    public void saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
        attrService.saveAttrInfo(pmsBaseAttrInfo);
    }

    //平台销售属性
    @RequestMapping("baseSaleAttrList")
    public List<PmsBaseSaleAttr> getBaseSaleAttrList(){
        List<PmsBaseSaleAttr> pmsBaseSaleAttrs=attrService.getBaseSaleAttrList();
        return pmsBaseSaleAttrs;
    }

}