package com.heima.model.article.dtos;

import com.heima.model.common.dtos.PageRequestDto;
import lombok.Data;

/**
 * @author 亚平
 */
@Data
public class AuthorDto extends PageRequestDto {
    /**
     * 状态
     */
    private Short status;
    /**
     * 认证的id
     */
    private Integer id;
    /**
     * 拒绝原因
     */
    private String msg;
}
