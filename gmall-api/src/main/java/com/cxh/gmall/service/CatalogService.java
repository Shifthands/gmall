package com.cxh.gmall.service;

import com.cxh.gmall.bean.PmsBaseCatalog1;
import com.cxh.gmall.bean.PmsBaseCatalog2;
import com.cxh.gmall.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * CatalogService
 *
 * @Author: 陈晓翰
 * @CreateTime: 2020-03-02
 * @Description:
 */
public interface CatalogService {

    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}