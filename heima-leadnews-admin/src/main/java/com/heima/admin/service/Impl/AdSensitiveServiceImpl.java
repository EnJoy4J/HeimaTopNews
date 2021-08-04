package com.heima.admin.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.admin.mapper.AdSensitiveMapper;
import com.heima.admin.service.AdSensitiveService;
import com.heima.model.admin.dtos.SensitiveDto;
import com.heima.model.admin.pojos.AdSensitive;
import com.heima.model.common.dtos.PageResponseResult;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdSensitiveServiceImpl
        extends ServiceImpl<AdSensitiveMapper, AdSensitive>
        implements AdSensitiveService {


    @Override
    public ResponseResult list(SensitiveDto sensitiveDto) {
        //检查参数
//        String dtoName = sensitiveDto.getName();
        if (null == sensitiveDto) {
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
            lambdaQueryWrapper.like(
                    AdSensitive::getSensitives, sensitiveDto.getName());
        }
        //根据条件进行分页查询
        IPage result = page(page, lambdaQueryWrapper);
        //封装返回值属性
        ResponseResult responseResult = new PageResponseResult(
                sensitiveDto.getPage(), sensitiveDto.getSize(), (int) result.getTotal());
        //封装返回值查询结果
        responseResult.setData(result.getRecords());
        //返回结果对象
        return responseResult;
    }

    @Override
    public ResponseResult insert(AdSensitive adSensitive) {
        //1.参数判断
        if (null == adSensitive) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        if (StringUtils.isBlank(adSensitive.getSensitives())) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        adSensitive.setCreated_time(new Date());
        save(adSensitive);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult deleteById(Integer id) {
        if (null == id) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        AdSensitive adSensitive = getById(id);
        if (null == adSensitive) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        removeById(id);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult update(AdSensitive adSensitive) {
        //如果对象为空，那么返回失败
        if (null == adSensitive) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        //如果对象 敏感词为空，那么返回失败
        if (StringUtils.isBlank(adSensitive.getSensitives())){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        updateById(adSensitive);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}
