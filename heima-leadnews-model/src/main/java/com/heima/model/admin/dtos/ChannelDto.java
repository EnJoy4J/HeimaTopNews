package com.heima.model.admin.dtos;

import com.heima.model.common.dtos.PageRequestDto;
import lombok.Data;

/**
 * 继承PageRequestDto 以获得page，size，同时获得参数检查方法
 */
@Data
public class ChannelDto extends PageRequestDto {

    //频道名称
    private String name;

}
