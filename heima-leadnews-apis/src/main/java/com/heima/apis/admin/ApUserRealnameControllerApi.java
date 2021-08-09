package com.heima.apis.admin;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.AuthDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 亚平
 */
@Api(value = "用户实名认证",tags = "Realname",description = "实名认证API")
public interface ApUserRealnameControllerApi {
    /**
     *  根据状态加载
     * @param dto
     * @return 响应状态
     *
     */
    @ApiOperation("根据状态加载认证用户信息")
    public ResponseResult loadListByStatus(AuthDto dto);
}
