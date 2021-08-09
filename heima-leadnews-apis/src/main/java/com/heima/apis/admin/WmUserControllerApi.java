package com.heima.apis.admin;

import com.alibaba.nacos.client.utils.JSONUtils;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.media.pojos.WmUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 亚平
 */
@Api(value = "自媒体用户管理",tags = "WmUser",description = "自媒体用户管理api")
public interface WmUserControllerApi {
    /**
     * 保存自媒体用户
     * @param user
     * @return
     */
    @ApiOperation("保存自媒体用户")
    public ResponseResult save(WmUser user);

    /**
     * 根据名称查找自媒体用户
     * @param userName
     * @return
     */
    @ApiOperation("根据名称查找自媒体用户")
    public WmUser findByName(String userName);

}
