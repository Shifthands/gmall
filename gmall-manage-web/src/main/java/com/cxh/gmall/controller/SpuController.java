package com.cxh.gmall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cxh.gmall.bean.PmsProductImage;
import com.cxh.gmall.bean.PmsProductInfo;
import com.cxh.gmall.bean.PmsProductSaleAttr;
import com.cxh.gmall.service.SpuService;
import com.cxh.gmall.util.GmallUploadUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * SpuController
 *
 * @Author: 陈晓翰
 * @CreateTime: 2020-03-03
 * @Description:
 */
@RestController
@CrossOrigin
public class SpuController {
    @Reference
    SpuService spuService;

    @RequestMapping("fileUpload")
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        String url = GmallUploadUtil.uploadFile(multipartFile);
        return url;
    }

    @RequestMapping("saveSpuInfo")
    public void saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {
        spuService.saveSpuInfo(pmsProductInfo);
    }

    @RequestMapping("spuList")
    public List<PmsProductInfo> getSpuList(String catalog3Id) {
        List<PmsProductInfo> spuList = spuService.getSpuList(catalog3Id);
        return spuList;
    }

    @RequestMapping("spuSaleAttrList")
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {
        List<PmsProductSaleAttr> pmsProductSaleAttrs = spuService.getSpuSaleAttrList(spuId);
        return pmsProductSaleAttrs;
    }

    @RequestMapping("spuImageList")
    public List<PmsProductImage> spuImageList(String spuId) {
        List<PmsProductImage> pmsProductImages = spuService.getSpuImageList(spuId);
        return pmsProductImages;
    }


}