package com.heima.admin.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.admin.mapper.AdSensitiveMapper;
import com.heima.admin.service.AdChannelService;
import com.heima.admin.service.AdSensitiveService;
import com.heima.model.admin.dtos.SensitiveDto;
import com.heima.model.admin.pojos.AdSensitive;
import com.heima.model.common.dtos.PageResponseResult;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdSensitiveServiceImpl
        extends ServiceImpl<AdSensitiveMapper, AdSensitive>
        implements AdSensitiveService {


    @Override
    public ResponseResult list(SensitiveDto sensitiveDto) {
        //检查参数
        String dtoName = sensitiveDto.getName();
        if (null == dtoName) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        sensitiveDto.checkParam();
        //创建分页对象
        Page page = new Page<>(sensitiveDto.getPage(), sensitiveDto.getSize());

        //创建查询对象
        LambdaQueryWrapper<AdSensitive> lambdaQueryWrapper = new LambdaQueryWrapper();

        //判断敏感词是否不为空(有内容：设置为模糊查询；没有内容：设置为查询所有)
        if (StringUtils.isNotBlank(sensitiveDto.getName())) {
            //如果不为空
            lambdaQueryWrapper.like(AdSensitive::getSensitives, sensitiveDto.getName());
        }
        //根据条件进行分页查询
        IPage result = page(page, lambdaQueryWrapper);
        //封装返回值属性
        ResponseResult responseResult = new PageResponseResult(sensitiveDto.getPage(), sensitiveDto.getSize(), (int) result.getTotal());
        //封装返回值查询结果
        responseResult.setData(result);
        //返回结果对象
        System.out.println(result);
        return responseResult;
    }

    @Override
    public ResponseResult insert(AdSensitive adSensitive) {
        return null;
    }

    @Override
    public ResponseResult deleteById(Integer id) {
        return null;
    }

    @Override
    public ResponseResult update(AdSensitive adSensitive) {
        return null;
    }
}
