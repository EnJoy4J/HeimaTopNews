package com.heima.atricle.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.atricle.mapper.AuthorMapper;
import com.heima.atricle.service.AuthorService;
import com.heima.model.article.dtos.AuthorDto;
import com.heima.model.article.pojos.ApAuthor;
import org.springframework.stereotype.Service;

/**
 * @author 亚平
 */
@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, ApAuthor> implements AuthorService {
}
