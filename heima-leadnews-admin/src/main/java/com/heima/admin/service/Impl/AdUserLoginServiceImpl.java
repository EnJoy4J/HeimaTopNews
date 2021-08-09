package com.heima.admin.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.heima.admin.mapper.AdUserMapper;
import com.heima.admin.service.UserLoginService;
import com.heima.model.admin.dtos.AdUserDto;
import com.heima.model.admin.pojos.AdUser;
import com.heima.model.common.dtos.ResponseResult;

import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.utils.common.AppJwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdUserLoginServiceImpl extends ServiceImpl<AdUserMapper, AdUser> implements UserLoginService {

    /**
     * 1.校验参数
     * 2.查表用户是否存在
     * 3.封装数据，返回结果
     *
     * @param adUserDto 前端页面传输的对象
     * @return
     */
    @Override
    public ResponseResult login(AdUserDto adUserDto) {
        //1.参数校验
        if (StringUtils.isEmpty(adUserDto.getName()) || StringUtils.isEmpty(adUserDto.getPassword())) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE, "用户名或者密码不能为空");
        }
        //2.查表
        Wrapper wrapper = new QueryWrapper<AdUser>();
        ((QueryWrapper) wrapper).eq("name", adUserDto.getName());
        List<AdUser> list = list(wrapper);
        //判断查询结果
        if (list != null && list.size() == 1) {
            //如果用户存在，那就核对密码
            /**
             * @adUser 数据库中的用户对象
             */
            AdUser adUser = list.get(0);
            //用用户的盐+输入的盐进行计算，得到一个md5值
            // TODO: 2021/8/4 为什么用手动加密的不用BCrypt
            String password = DigestUtils.md5DigestAsHex((  adUserDto.getPassword()+adUser.getSalt()).getBytes());
            //如果密码对的上，说明可以登录
            if (password.equals(adUser.getPassword())) {
                // TODO: 2021/8/3 这里为什么要新建一个数组 
                // TODO: 2021/8/3 这里新建数组的方式为什么这么奇怪
                Map<String, Object> hashmap = Maps.newHashMap();
                adUser.setPassword("");
                adUser.setSalt("");
                // TODO: 2021/8/3 这是什么方法

                hashmap.put("token", AppJwtUtil.getToken(adUser.getId().longValue()));
                hashmap.put("user", adUser);
                return ResponseResult.okResult(hashmap);
            } else {
                return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "输入的密码有误");
            }
        } else {

            return ResponseResult.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST, "用户不存在");
        }

    }
}
