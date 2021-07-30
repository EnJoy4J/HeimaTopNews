package com.heima.apis.admin;

import com.heima.model.admin.dtos.ChannelDto;
import com.heima.model.admin.pojos.AdChannel;
import com.heima.model.common.dtos.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "频道管理",tags = "channel",description = "频道管理API")
public interface AdChannelControllerApi {
    /**
     * 根据名称分页查询频道列表
     * @param dto
     * @return
     */
    @ApiOperation("根据名称分页查询频道列表 ")
    public ResponseResult findByNameAndPage(ChannelDto dto);

    /**
     * 添加频道
     * @param adChannel
     * @return
     */
    @ApiOperation("添加频道")
    public  ResponseResult save(AdChannel adChannel);


}
