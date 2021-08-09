package com.heima.atricle.controller.v1;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.heima.apis.admin.AuthorControllerApi;
import com.heima.atricle.service.AuthorService;
import com.heima.model.article.pojos.ApAuthor;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/v1/author")
public class AuthorControllerImpl implements AuthorControllerApi {
    @Autowired
    private AuthorService authorService;

    /**
     * 保存作者
     *
     * @param apAuthor
     * @return
     */
    @PostMapping("/save")
    @Override
    public ResponseResult save(@RequestBody ApAuthor apAuthor) {
        //创建作者对象
        apAuthor.setCreatedTime(new Date());
        //保存作者对象
        authorService.save(apAuthor);
        //返回响应结果对象
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 根据用户id查找用户
     *
     * @param id
     * @return
     */
    @GetMapping("/findByUserId/{id}")
    @Override
    public com.heima.model.article.pojos.ApAuthor findByUserId(@PathVariable("id") Integer id) {
        //创建查询条件
        LambdaQueryWrapper<com.heima.model.article.pojos.ApAuthor> lambdaQueryWrapper = new LambdaQueryWrapper();
        //设置查询条件
        lambdaQueryWrapper.eq(com.heima.model.article.pojos.ApAuthor::getUserId,id);
        //生成结果集合
        List<com.heima.model.article.pojos.ApAuthor> apAuthorList = authorService.list(lambdaQueryWrapper);
        //判断如果集合不为空，则返回元素
        if (! (apAuthorList==null||apAuthorList.size()==0)){
            return apAuthorList.get(0);
        }
        //如果集合为空，则返回空
        return null;
    }
}
