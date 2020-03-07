package com.cxh.gmall.service;

import com.cxh.gmall.bean.PmsProductImage;
import com.cxh.gmall.bean.PmsProductInfo;
import com.cxh.gmall.bean.PmsProductSaleAttr;

import java.util.List;

/**
 * SpuService
 *
 * @Author: 陈晓翰
 * @CreateTime: 2020-03-05
 * @Description:
 */
public interface SpuService {
    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductInfo> getSpuList(String catalog3Id);

    List<PmsProductSaleAttr> getSpuSaleAttrList(String spuId);

    List<PmsProductImage> getSpuImageList(String spuId);

    List<PmsProductSaleAttr> getSpuSaleAttrListBySql(String spuId, String skuId);
}