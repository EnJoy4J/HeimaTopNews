package com.heima.wemedia.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.heima.apis.admin.WmUserControllerApi;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.media.pojos.WmUser;
import com.heima.wemedia.service.WmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
public class WmUserController implements WmUserControllerApi {
    @Autowired
    private WmUserService wmUserService;
    @Override
    @PostMapping("/save")
    /**
     * 保存自媒体用户
     */
    public ResponseResult save(@RequestBody WmUser wmUser) {
        wmUserService.save(wmUser);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    @GetMapping("/findByName/{name}")
    /**
     *创建一个查询条件，在所有自媒体用户中匹配名字和参数相同的值
     * 如果获取结果为空，则说明不存在这样的用户，所以返回null
     * 如果获取到值，则将这个对象返回
     */
    public WmUser findByName(@PathVariable String userName) {
        LambdaQueryWrapper<WmUser> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(WmUser::getName,userName);
        List<WmUser> list = wmUserService.list(lambdaQueryWrapper);
         if (!list.isEmpty()&&list!=null){
             return list.get(0);
         }
        return null;
    }
}
