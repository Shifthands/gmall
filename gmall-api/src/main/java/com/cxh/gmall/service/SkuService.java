package com.cxh.gmall.service;

import com.cxh.gmall.bean.PmsSkuInfo;

import java.util.List;

/**
 * SkuService
 *
 * @Author: 陈晓翰
 * @CreateTime: 2020-03-05
 * @Description:
 */
public interface SkuService {
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    PmsSkuInfo getSkuInfoBySkuId(String skuId);

    List<PmsSkuInfo> getSkuInfoBySpuId(String spuId);
}