package com.heima.admin.controller.v1;

import com.heima.admin.service.UserLoginService;
import com.heima.apis.admin.LoginControllerApi;
import com.heima.model.admin.dtos.AdUserDto;
import com.heima.model.common.dtos.ResponseResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController implements LoginControllerApi {
    @Autowired
    private UserLoginService userloginService;
    @Override
    @PostMapping("/in")
    public ResponseResult login(@RequestBody AdUserDto adUserDto) {
        return userloginService.login(adUserDto);
    }
}
