package com.cxh.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cxh.gmall.bean.*;
import com.cxh.gmall.manage.mapper.*;
import com.cxh.gmall.service.SkuService;
import com.cxh.gmall.service.SpuService;
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
public class SKuServiceImpl implements SkuService {

    @Autowired
    PmsSkuInfoMapper skuInfoMapper;
    @Autowired
    PmsSkuImageMapper pmsSkuImageMapper;
    //平台属性值
    @Autowired
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;
    //销售属性值
    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {
        skuInfoMapper.insert(pmsSkuInfo);
        String skuInfoId = pmsSkuInfo.getId();

        List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
        for (PmsSkuImage pmsSkuImage : skuImageList) {
            pmsSkuImage.setSkuId(skuInfoId);
            pmsSkuImageMapper.insert(pmsSkuImage);
        }

        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
            pmsSkuSaleAttrValue.setSkuId(skuInfoId);
            pmsSkuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);
        }

        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
            pmsSkuAttrValue.setSkuId(skuInfoId);
            pmsSkuAttrValueMapper.insertSelective(pmsSkuAttrValue);
        }
    }

    @Override
    public PmsSkuInfo getSkuInfoBySkuId(String skuId) {
        //skuInfo
        PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
        pmsSkuInfo.setId(skuId);
        PmsSkuInfo skuInfoResult = skuInfoMapper.selectOne(pmsSkuInfo);
        //图片列表
        PmsSkuImage pmsSkuImage = new PmsSkuImage();
        pmsSkuImage.setSkuId(skuId);
        List<PmsSkuImage> skuImages = pmsSkuImageMapper.select(pmsSkuImage);
        skuInfoResult.setSkuImageList(skuImages);

        return skuInfoResult;
    }

    @Override
    public List<PmsSkuInfo> getSkuInfoBySpuId(String spuId) {
        List<PmsSkuInfo> pmsSkuInfos = skuInfoMapper.getSkuInfoBySpuId(spuId);
        return pmsSkuInfos;
    }
}