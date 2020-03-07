package com.cxh.gmall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cxh.gmall.bean.PmsBaseCatalog1;
import com.cxh.gmall.bean.PmsBaseCatalog2;
import com.cxh.gmall.bean.PmsBaseCatalog3;
import com.cxh.gmall.service.CatalogService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CatalogController
 *
 * @Author: 陈晓翰
 * @CreateTime: 2020-03-02
 * @Description:
 */
@CrossOrigin
@RestController
public class CatalogController {
    @Reference
    CatalogService catalogService;
    @RequestMapping("getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1(){
        List<PmsBaseCatalog1> catalog1s=catalogService.getCatalog1();
        return catalog1s;
    }

//getCatalog2?catalog1Id=2:1 Failed to load resource: net::ERR_FAILED
    @RequestMapping("getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id){
        List<PmsBaseCatalog2> catalog2s=catalogService.getCatalog2(catalog1Id);
        return catalog2s;
    }
    //getCatalog3?catalog2Id=13
    @RequestMapping("getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id){
        List<PmsBaseCatalog3> catalog3s=catalogService.getCatalog3(catalog2Id);
        return catalog3s;
    }

}