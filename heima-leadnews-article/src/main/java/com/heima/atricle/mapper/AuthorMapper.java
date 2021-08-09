package com.heima.atricle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.article.pojos.ApAuthor;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 亚平
 */
@Mapper
public interface AuthorMapper extends BaseMapper<ApAuthor> {
}
