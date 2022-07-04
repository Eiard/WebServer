package com.ytz.web.mapper;

import com.ytz.web.domain.Finance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.mapper
 * @className: FinanceMapper
 * @author: 30671
 * @description: DONE : 针对表【finance】的数据库操作Mapper
 * @date: 2022/7/4
 * @Entity com.ytz.web.domain.Finance
 * @version: 1.0
 */
@Mapper
public interface FinanceMapper extends BaseMapper<Finance> {

}




