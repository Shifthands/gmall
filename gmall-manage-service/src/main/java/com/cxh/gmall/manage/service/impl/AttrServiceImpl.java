package com.cxh.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cxh.gmall.bean.PmsBaseAttrInfo;
import com.cxh.gmall.bean.PmsBaseAttrValue;
import com.cxh.gmall.bean.PmsBaseSaleAttr;
import com.cxh.gmall.manage.mapper.AttrMapper;
import com.cxh.gmall.manage.mapper.AttrValueMapper;
import com.cxh.gmall.manage.mapper.PmsBaseSaleAttrMapper;
import com.cxh.gmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * AttrServiceImpl
 *
 * @Author: 陈晓翰
 * @CreateTime: 2020-03-03
 * @Description:
 */
@Service
public class AttrServiceImpl implements AttrService {
    @Autowired
    AttrMapper attrMapper;
    @Autowired
    AttrValueMapper attrValueMapper;
    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;
    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {

        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = attrMapper.select(pmsBaseAttrInfo);
        for (PmsBaseAttrInfo baseAttrInfo : pmsBaseAttrInfos) {
            String attrInfoId = baseAttrInfo.getId();
            PmsBaseAttrValue baseAttrValue = new PmsBaseAttrValue();
            baseAttrValue.setAttrId(attrInfoId);
            List<PmsBaseAttrValue> baseAttrValues = attrValueMapper.select(baseAttrValue);
            baseAttrInfo.setAttrValueList(baseAttrValues);
        }
        return pmsBaseAttrInfos;
    }

    @Override
    public void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        //插入属性表
        attrMapper.insertSelective(pmsBaseAttrInfo);
        //返回id
        String id=pmsBaseAttrInfo.getId();
        //插入属性值表
        List<PmsBaseAttrValue> pmsBaseAttrValueList=pmsBaseAttrInfo.getAttrValueList();
        for (PmsBaseAttrValue pmsBaseAttrValue : pmsBaseAttrValueList) {
            pmsBaseAttrValue.setAttrId(id);
            attrValueMapper.insertSelective(pmsBaseAttrValue);
        }
    }

    @Override
    public List<PmsBaseSaleAttr> getBaseSaleAttrList() {
        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = pmsBaseSaleAttrMapper.selectAll();
        return pmsBaseSaleAttrs;
    }
}