package com.heima.apis.admin;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.AuthDto;

/**
 * @author 亚平
 */
public interface ApUserRealnameControllerApi {
    /**
     *  根据状态加载
     * @param dto
     * @return 响应状态
     *
     */
    public ResponseResult loadListByStatus(AuthDto dto);
}
