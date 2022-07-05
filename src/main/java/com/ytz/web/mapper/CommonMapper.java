package com.ytz.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.mapper
 * @className: CommonMapper
 * @author: 30671
 * @description: TODO : 公共自定义SQL
 * @date: 2022/7/5
 * @Entity 无需实现类
 * @version: 1.0
 */
@Mapper
@Repository("commonMapper")
public interface CommonMapper {

    /**
     * @MethodName: phoneIsExist
     * @Description: DONE : 在所有表中寻找手机号是否存在
     * @Author: 30671
     * @date: 2022/7/5
     * @param: phone  手机号
     * @return: boolean
     */
    public boolean phoneIsExist(String phone);

}
