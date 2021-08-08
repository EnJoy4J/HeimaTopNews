package com.heima.model.user.dtos;

import com.heima.model.common.dtos.PageRequestDto;
import lombok.Data;

/**
 * @author 亚平
 * 创建一个关于用户认证的状态dto
 */
@Data
public class AuthDto extends PageRequestDto {

    private Integer id;
    //驳回的信息
    private String msg;
    //状态
    private Short status;
}
