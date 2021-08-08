package com.heima.user.controller;


import com.heima.apis.admin.ApUserRealnameControllerApi;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.AuthDto;
import com.heima.user.service.ApUserRealnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 亚平
 */
@RestController
@RequestMapping("/api/v1/auth")
public class ApUserRealnameController implements ApUserRealnameControllerApi {
    @Autowired
    private ApUserRealnameService apUserRealnameService;

    @PostMapping("/list")
    @Override
    public ResponseResult loadListByStatus(AuthDto dto) {
        return apUserRealnameService.loadListByStatus(dto);
    }
}
