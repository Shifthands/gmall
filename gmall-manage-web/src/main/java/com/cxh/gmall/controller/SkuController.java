package com.cxh.gmall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cxh.gmall.bean.PmsProductImage;
import com.cxh.gmall.bean.PmsProductInfo;
import com.cxh.gmall.bean.PmsProductSaleAttr;
import com.cxh.gmall.bean.PmsSkuInfo;
import com.cxh.gmall.service.SkuService;
import com.cxh.gmall.service.SpuService;
import com.cxh.gmall.util.GmallUploadUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.midi.Soundbank;
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
public class SkuController {
    @Reference
    SkuService skuService;
   @RequestMapping("saveSkuInfo")
    public void saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo){
       skuService.saveSkuInfo(pmsSkuInfo);
   }

}