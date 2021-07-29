package com.heima.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.admin.pojos.AdChannel;
import org.apache.ibatis.annotations.Mapper;

/**
 * 继承BaseMapper，泛型定义为AdChannel
 *
 */
@Mapper
public interface AdChannelMapper extends BaseMapper<AdChannel> {
}
