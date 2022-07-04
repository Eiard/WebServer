package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.Finance;
import com.ytz.web.service.FinanceService;
import com.ytz.web.mapper.FinanceMapper;
import org.springframework.stereotype.Service;

/**
* @author 30671
* @description 针对表【finance】的数据库操作Service实现
* @createDate 2022-07-04 19:01:28
*/
@Service
public class FinanceServiceImpl extends ServiceImpl<FinanceMapper, Finance>
    implements FinanceService{

}




