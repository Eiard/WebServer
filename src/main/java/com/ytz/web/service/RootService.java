package com.ytz.web.service;

import com.ytz.web.domain.Root;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service
 * @className: RootService
 * @author: 30671
 * @description: TODO : 针对表【root】的数据库操作Service
 * @date: 2022/7/4
 * @version: 1.0
 */
@Deprecated
public interface RootService extends IService<Root> {

    /**
     * @MethodName: phoneIsExist
     * @Description: DONE : 手机号存在
     * @Author: 30671
     * @date: 2022/7/5
     * @param: phone  手机号
     * @return: boolean
     */
    boolean phoneIsExist(String phone);
}
