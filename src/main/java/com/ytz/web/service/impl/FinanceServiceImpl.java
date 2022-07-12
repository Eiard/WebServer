package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.Finance;
import com.ytz.web.service.FinanceService;
import com.ytz.web.mapper.FinanceMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service.impl
 * @className: FinanceServiceImpl
 * @author: 30671
 * @description: TODO : 针对表【finance】的数据库操作Service实现
 * @date: 2022/7/5
 * @version: 1.0
 */
@Service("financeServiceImpl")
public class FinanceServiceImpl extends ServiceImpl<FinanceMapper, Finance>
    implements FinanceService{

}




