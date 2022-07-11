package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.Root;
import com.ytz.web.mapper.RootMapper;
import com.ytz.web.service.RootService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service.impl
 * @className: RootServiceImpl
 * @author: 30671
 * @description: TODO : 针对表【root】的数据库操作Service实现
 * @date: 2022/7/5
 * @version: 1.0
 */
@Deprecated
@Service
@Repository("rootServiceImpl")
public class RootServiceImpl extends ServiceImpl<RootMapper, Root>
        implements RootService {

}




