package com.heima.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.AuthDto;
import com.heima.model.user.pojos.ApUserRealname;
import org.springframework.stereotype.Service;

/**
 * @author 亚平
 */

public interface ApUserRealnameService extends IService<ApUserRealname> {
    /**
     * 根据状态分页查询用户列表
     * @param dto
     * @return
     */
    public ResponseResult loadListByStatus(AuthDto dto);
}
