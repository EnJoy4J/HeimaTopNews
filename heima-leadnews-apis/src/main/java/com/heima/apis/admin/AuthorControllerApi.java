package com.heima.apis.admin;


import com.heima.model.article.pojos.ApAuthor;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 亚平
 */
public interface AuthorControllerApi {
    /**
     * 保存作者
     *
     * @param apAuthor
     * @return
     */
    public ResponseResult save(@RequestBody ApAuthor apAuthor);

    /**
     * 根据用户id查找作者
     *
     * @param id
     * @return
     */
    public com.heima.model.article.pojos.ApAuthor findByUserId(Integer id);
}
