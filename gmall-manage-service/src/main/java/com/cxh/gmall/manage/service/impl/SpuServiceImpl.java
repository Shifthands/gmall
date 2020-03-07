package com.cxh.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cxh.gmall.bean.*;
import com.cxh.gmall.manage.mapper.*;
import com.cxh.gmall.service.AttrService;
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
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;
    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;
    @Autowired
    PmsProductImageMapper pmsProductImageMapper;
    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {
        //插入spuinfo返回SPUid
        pmsProductInfoMapper.insertSelective(pmsProductInfo);
        String spuId=pmsProductInfo.getId();
        //插入销售属性列表（带spuId）
        List<PmsProductSaleAttr> spuSaleAttrList = pmsProductInfo.getSpuSaleAttrList();
        for (PmsProductSaleAttr spuSaleAttr : spuSaleAttrList) {
            spuSaleAttr.setProductId(spuId);
            pmsProductSaleAttrMapper.insertSelective(spuSaleAttr);

            //插入销售属性值列表（带spuId）
            for (PmsProductSaleAttrValue saleAttrValue : spuSaleAttr.getSpuSaleAttrValueList()) {
                saleAttrValue.setProductId(spuId);
                pmsProductSaleAttrValueMapper.insertSelective(saleAttrValue);
            }
        }
        //插入销售图片列表
        List<PmsProductImage> spuImageList = pmsProductInfo.getSpuImageList();
        for (PmsProductImage pmsProductImage : spuImageList) {
            pmsProductImage.setProductId(spuId);
            pmsProductImageMapper.insertSelective(pmsProductImage);
        }


    }

    @Override
    public List<PmsProductInfo> getSpuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> pmsProductInfos = pmsProductInfoMapper.select(pmsProductInfo);
        return pmsProductInfos;
    }

    @Override
    public List<PmsProductSaleAttr> getSpuSaleAttrList(String spuId) {
        //spu销售属性
        PmsProductSaleAttr pmsProductSaleAttr = new PmsProductSaleAttr();
        pmsProductSaleAttr.setProductId(spuId);
        List<PmsProductSaleAttr> pmsProductSaleAttrs = pmsProductSaleAttrMapper.select(pmsProductSaleAttr);

        //spu销售属性值
        for (PmsProductSaleAttr productSaleAttr : pmsProductSaleAttrs) {
            String saleAttrId=productSaleAttr.getSaleAttrId();

            PmsProductSaleAttrValue pmsProductSaleAttrValue = new PmsProductSaleAttrValue();
            pmsProductSaleAttrValue.setProductId(spuId);
            pmsProductSaleAttrValue.setSaleAttrId(saleAttrId);
            List<PmsProductSaleAttrValue> saleAttrValues = pmsProductSaleAttrValueMapper.select(pmsProductSaleAttrValue);

            productSaleAttr.setSpuSaleAttrValueList(saleAttrValues);
        }

        return pmsProductSaleAttrs;
    }

    @Override
    public List<PmsProductImage> getSpuImageList(String spuId) {
        PmsProductImage pmsProductImage = new PmsProductImage();
        pmsProductImage.setProductId(spuId);
        List<PmsProductImage> pmsProductImages = pmsProductImageMapper.select(pmsProductImage);
        return pmsProductImages;
    }

    @Override
    public List<PmsProductSaleAttr> getSpuSaleAttrListBySql(String spuId, String skuId) {
        List<PmsProductSaleAttr> spuSaleAttrListBySql = pmsProductSaleAttrMapper.getSpuSaleAttrListBySql(spuId, skuId);
        return spuSaleAttrListBySql;
    }
}