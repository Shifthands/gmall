package com.cxh.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.cxh.gmall.bean.PmsProductSaleAttr;
import com.cxh.gmall.bean.PmsSkuAttrValue;
import com.cxh.gmall.bean.PmsSkuInfo;
import com.cxh.gmall.bean.PmsSkuSaleAttrValue;
import com.cxh.gmall.service.SkuService;
import com.cxh.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * itemController
 *
 * @Author: 陈晓翰
 * @CreateTime: 2020-03-06
 * @Description:
 */
@Controller
public class itemController {
    @Reference
    SkuService skuService;
    @Reference
    SpuService spuService;
    @RequestMapping("{skuId}.html")
    public String item(@PathVariable("skuId") String skuId, ModelMap map){
       PmsSkuInfo skuInfoBySkuId = skuService.getSkuInfoBySkuId(skuId);
        map.put("skuInfo",skuInfoBySkuId);

        //查询属性值和属性列表,根据skuId查询选中的属性值
        List<PmsProductSaleAttr> spuSaleAttrList = spuService.getSpuSaleAttrListBySql(skuInfoBySkuId.getSpuId(),skuInfoBySkuId.getId());
        map.put("spuSaleAttrListCheckBySku",spuSaleAttrList);

        //切换销售属性的数据列表
        List<PmsSkuInfo> skuInfos = skuService.getSkuInfoBySpuId(skuInfoBySkuId.getSpuId());

        //将属性列表作为json字符串放入页面
         Map<String,String> jsonmap = new HashMap();
        for (PmsSkuInfo skuInfo : skuInfos) {
            String k="";
            String v=skuInfo.getId();
            List<PmsSkuSaleAttrValue> skuSaleAttrValues = skuInfo.getSkuSaleAttrValueList();
            for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue: skuSaleAttrValues) {
                k=k+"|"+pmsSkuSaleAttrValue.getId();
            }
            jsonmap.put(k,v);
        }
        String jsonString = JSON.toJSONString(jsonmap);
        map.put("skuSaleAttrValueJson",jsonString);
        return "item";
    }
}