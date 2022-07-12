package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.User;
import com.ytz.web.mapper.UserMapper;
import com.ytz.web.service.UserService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service.impl
 * @className: UserServiceImpl
 * @author: 30671
 * @description: TODO : 针对表【user】的数据库操作Service实现(后续选择性实现)
 * @date: 2022/7/4
 * @version: 1.0
 */
@Deprecated
@Service("userServiceImpl")
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

}




