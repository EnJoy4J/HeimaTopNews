/*
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

import java.util.List;
import java.util.Map;

@Service
@Transactional//(readOnly = true) //todo 事务？完不成 立即回滚
public class UserLoginServiceImpl extends ServiceImpl<AdUserMapper, AdUser> implements UserLoginService {

    */
/**
     * 登录校验
     *
     * @param dto
     * @return
     *//*

    @Override
    public ResponseResult login(AdUserDto dto) {
        //1.参数校验 判断用户名是否为空，或者用户密码是否空
        if (StringUtils.isEmpty(dto.getName()) || StringUtils.isEmpty(dto.getPassword())) {
            //2.假如为空，就返回错误结果
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE, "用户名或密码不能为空");
        }
        // TODO: 2021/8/3 这里为什么先写Wrapper，然后又要转成QueryWrapper
        //3.创建查询对象
        Wrapper wrapper = new QueryWrapper<AdUser>();
        //4.查询名字列，与之相同的名字
        ((QueryWrapper) wrapper).eq("name", dto.getName());
        //5.根据范围使用列表查询
        List<AdUser> list = list(wrapper);
        //6.如果集合不为空，并且集合中元素只有1
        if (list != null && list.size() == 1) {
            //7.拿到这个元素（用户）
            AdUser adUser = list.get(0);
            //8.用 输入的密码+盐 计算MD5码（todo 盐要从用户获得？）
            String pswd = DigestUtils.md5DigestAsHex((dto.getPassword() + adUser.getSalt()).getBytes());
            // TODO: 2021/8/3  //9.假如用户密码与计算生成的md5码相等，那么给这个用户生成密码与盐？
            if (adUser.getPassword().equals(pswd)) {
                //新建一个集合
                Map<String, Object> map = Maps.newHashMap();
                adUser.setPassword("");
                adUser.setSalt("");
                //集合中放入token，adUser
                map.put("token", AppJwtUtil.getToken(adUser.getId().longValue()));
                map.put("user", adUser);
                //返回结果
                return ResponseResult.okResult(map);
            } else {
                //如果用户密码与计算生成的md5不相等，返回密码错误
                return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
            }
        } else {
            //如果集合为空，说明查不到这个用户，返回用户不存在
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST, "用户不存在");
        }
    }
}
*/
