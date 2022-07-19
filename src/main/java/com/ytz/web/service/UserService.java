package com.ytz.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ytz.web.domain.User;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service
 * @className: UserService
 * @author: 30671
 * @description: FIXME : 针对表【user】的数据库操作Service(后续选择性实现)
 * @date: 2022/7/4
 * @version: 1.0
 */
@Deprecated
public interface UserService extends IService<User> {

    /**
     * @MethodName: findByUsername
     * @Description: DONE : 判断用户名是否重复
     * @Author: Delmore
     * @date: 2022/7/17
     * @param: username
     * @return: com.ytz.web.domain.User
     **/
    User findByUsername(String username);
}
