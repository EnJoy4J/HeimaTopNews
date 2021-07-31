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
    public ResponseResult insert(AdSensitive adSensitive) {
        return null;
    }

    @Override
    public ResponseResult deleteById(Integer id) {
        return null;
    }

    @Override
    public ResponseResult update(AdSensitive adSensitive) {
        return null;
    }
}
