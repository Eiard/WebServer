package com.ytz.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ytz.web.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.mapper
 * @className: UserMapper
 * @author: 30671
 * @description: DONE : 针对表【user】的数据库操作Mapper
 * @date: 2022/7/4
 * @Entity com.ytz.web.domain.User
 * @version: 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




