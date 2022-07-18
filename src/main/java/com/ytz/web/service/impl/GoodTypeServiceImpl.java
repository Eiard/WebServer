package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.GoodType;
import com.ytz.web.service.GoodTypeService;
import com.ytz.web.mapper.GoodTypeMapper;
import com.ytz.web.utils.PriceUtils;
import org.springframework.stereotype.Service;
import java.util.List;

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
@Service("goodTypeServiceImpl")
public class GoodTypeServiceImpl extends ServiceImpl<GoodTypeMapper, GoodType>
        implements GoodTypeService {

    @Override
    public List queryAllGoodTye() {
        return listMaps(new LambdaQueryWrapper<GoodType>()
                .select(GoodType::getTypeId,GoodType::getTypeName)
                .eq(GoodType::getIsDeleted, 0));
    }

    @Override
    public Double getFinalPrice(Double goodWeight, Integer goodType) {
        return PriceUtils.getFinalPrice(goodWeight, goodType);
    }
}