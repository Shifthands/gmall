package com.cxh.gmall.service;

import com.cxh.gmall.bean.PmsBaseAttrInfo;
import com.cxh.gmall.bean.PmsBaseSaleAttr;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * AttrService
 *
 * @Author: 陈晓翰
 * @CreateTime: 2020-03-03
 * @Description:
 */
public interface AttrService  {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseSaleAttr> getBaseSaleAttrList();
}