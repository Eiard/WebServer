package com.ytz.web.controller;

import com.ytz.web.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @projectName: web
 * @package: com.ytz.web.controller
 * @className: UserConntrol
 * @author: Delmore
 * @description: TODO
 * @date: 2022/7/17 13:36
 * @version: 1.0
 */
@Deprecated
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


    @PostMapping("/login")
    Boolean login(@RequestParam String username, @RequestParam String password){
        return userService.findByUsername(username).equals(password);
    }
}
