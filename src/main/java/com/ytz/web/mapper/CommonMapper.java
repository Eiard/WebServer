package com.ytz.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.mapper
 * @className: FinanceMapper
 * @author: Delmore
 * @description: DONE : 针对表所有人员电话的数据库操作Mapper
 * @date: 2022/7/11
 * @Entity com.ytz.web.domain.Finance
 * @version: 1.0
 */
@Mapper
@Repository("commonMapper")
public interface CommonMapper{

    /**
     * 判断手机号是否存在
     *
     * @param : phone
     * @return
     */
    int phoneIsExist(String phone);
}
