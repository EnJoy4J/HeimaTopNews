package com.heima.apis.admin;

import com.heima.model.admin.dtos.AdUserDto;

import com.heima.model.common.dtos.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 亚平
 *
 */
@Api(value = "用户登录",tags = "UserLogin",description = "用户登录api")
public interface LoginControllerApi {
    @ApiOperation("用户登录")    // TODO: 2021/8/3 这里怎么要写两次@RequestBody注释
    public ResponseResult login(@RequestBody AdUserDto adUserDto);
}
