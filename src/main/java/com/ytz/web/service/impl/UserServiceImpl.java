package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.User;
import com.ytz.web.service.UserService;
import com.ytz.web.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 30671
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-07-04 19:51:46
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




