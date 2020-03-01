package com.cxh.gmall.gmallservice.mapper;

import com.cxh.gmall.gmallservice.bean.UmsMember;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * UserMapper
 *
 * @Author: 陈晓翰
 * @CreateTime: 2020-03-01
 * @Description:
 */
@Repository
public interface UserMapper extends Mapper<UmsMember> {

}