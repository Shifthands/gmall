package com.cxh.gmall.manage.mapper;

import com.cxh.gmall.bean.PmsSkuInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * PmsSkuInfoMapper
 *
 * @Author: 陈晓翰
 * @CreateTime: 2020-03-05
 * @Description:
 */
public interface PmsSkuInfoMapper extends Mapper<PmsSkuInfo> {
    List<PmsSkuInfo> getSkuInfoBySpuId(String spuId);
}