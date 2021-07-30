package com.heima.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.admin.dtos.ChannelDto;
import com.heima.model.admin.pojos.AdChannel;
import com.heima.model.common.dtos.ResponseResult;


public interface AdChannelService extends IService<AdChannel> {
    /**
     * 根据名称分页查询频道列表
     * @param dto
     * @return
     */
    ResponseResult findByNameAndPage(ChannelDto dto);

    /**
     * 添加频道
     * @param adChannel
     * @return
     */
    ResponseResult insert(AdChannel adChannel);

    /**
     * 修改频道
     * @param adChannel
     * @return
     */
    ResponseResult update(AdChannel adChannel);

    /**
     * 删除频道
     * @param id
     * @return
     */
    ResponseResult deleteById(Integer id);
}
