package com.cxh.gmall.manage.mapper;

import com.cxh.gmall.bean.PmsProductSaleAttr;
import com.cxh.gmall.bean.PmsProductSaleAttrValue;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * PmsProductSaleAttrMapper
 *
 * @Author: 陈晓翰
 * @CreateTime: 2020-03-05
 * @Description:
 */
public interface PmsProductSaleAttrMapper extends Mapper<PmsProductSaleAttr> {
    List<PmsProductSaleAttr> getSpuSaleAttrListBySql(@Param("spuId") String spuId,@Param("skuId") String skuId);
}