package com.cxh.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cxh.gmall.bean.PmsBaseCatalog2;
import com.cxh.gmall.bean.PmsBaseCatalog3;
import com.cxh.gmall.manage.mapper.Catalog1Mapper;
import com.cxh.gmall.bean.PmsBaseCatalog1;
import com.cxh.gmall.manage.mapper.Catalog2Mapper;
import com.cxh.gmall.manage.mapper.Catalog3Mapper;
import com.cxh.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * CatalogServiceImpl
 *
 * @Author: 陈晓翰
 * @CreateTime: 2020-03-02
 * @Description:
 */
@Service
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    Catalog1Mapper catalog1Mapper;
    @Autowired
    Catalog2Mapper catalog2Mapper;
    @Autowired
    Catalog3Mapper catalog3Mapper;
    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> pmsBaseCatalog1s=catalog1Mapper.selectAll();
        return pmsBaseCatalog1s;
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        List<PmsBaseCatalog2> pmsBaseCatalog2s=catalog2Mapper.select(pmsBaseCatalog2);
        return pmsBaseCatalog2s;
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        List<PmsBaseCatalog3> pmsBaseCatalog3s=catalog3Mapper.select(pmsBaseCatalog3);
        return pmsBaseCatalog3s;
    }
}