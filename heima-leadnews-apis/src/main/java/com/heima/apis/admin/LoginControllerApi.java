package com.heima.apis.admin;

import com.heima.model.admin.dtos.AdUserDto;

import com.heima.model.common.dtos.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;


public interface LoginControllerApi {
    // TODO: 2021/8/3 这里怎么要写两次@RequestBody注释
public ResponseResult login(@RequestBody AdUserDto adUserDto);
}
