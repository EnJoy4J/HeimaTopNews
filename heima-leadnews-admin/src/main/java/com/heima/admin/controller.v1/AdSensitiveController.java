package com.heima.admin.controller.v1;


import com.heima.admin.service.AdSensitiveService;
import com.heima.apis.admin.AdChannelControllerApi;
import com.heima.apis.admin.AdSensitiveControllerApi;

import com.heima.model.admin.dtos.SensitiveDto;

import com.heima.model.admin.pojos.AdSensitive;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/sensitive")
public class AdSensitiveController implements AdSensitiveControllerApi {

    @Autowired
    private AdSensitiveService adSensitiveService;

    @Override
    @PostMapping("/list")
    public ResponseResult list(@RequestBody SensitiveDto sensitiveDto) {
        return adSensitiveService.list(sensitiveDto);
    }

    @Override
    @PostMapping("/insert")
    public ResponseResult insert(@RequestBody AdSensitive adSensitive) {
        return adSensitiveService.insert(adSensitive);
    }

    @Override
    @DeleteMapping("/del/{id}")
    public ResponseResult   deleteById(@PathVariable("id") Integer id) {
        return adSensitiveService.deleteById(id);
    }

    @Override
    @PostMapping("/update")
    public ResponseResult update(@RequestBody AdSensitive adSensitive) {
        return adSensitiveService.update(adSensitive);
    }
}
