package com.killer.demo.controller;

import com.killer.demo.po.BsUserPO;
import com.killer.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("qryUserSingle")
    @ResponseBody
    BsUserPO qryUser() {
        return userService.qryUser();
    }
}
