package com.ytz.web.service;

import com.ytz.web.mapper.CommonMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service
 * @className: CommonService
 * @author: 30671
 * @description: TODO : 不同service都会用到的相同操作
 * @date: 2022/7/5
 * @version: 1.0
 */
@Service
public interface CommonService {

    /**
     * @MethodName: phoneIsExist
     * @Description: DONE : 在所有表中寻找手机号是否存在
     * @Author: 30671
     * @date: 2022/7/5
     * @param: phone  手机号
     * @return: boolean
     */
    boolean phoneIsExist(String phone);

}
