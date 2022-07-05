package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.GoodType;
import com.ytz.web.service.GoodTypeService;
import com.ytz.web.mapper.GoodTypeMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service.impl
 * @className: goodTypeServiceImpl
 * @author: 30671
 * @description: TODO : 针对表【good_type】的数据库操作Service
 * @date: 2022/7/4
 * @version: 1.0
 */
@Service
@Repository("goodTypeServiceImpl")
public class GoodTypeServiceImpl extends ServiceImpl<GoodTypeMapper, GoodType>
    implements GoodTypeService{

}




