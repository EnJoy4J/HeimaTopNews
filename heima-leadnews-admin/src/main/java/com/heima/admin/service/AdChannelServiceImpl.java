package com.heima.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.admin.mapper.AdChannelMapper;
import com.heima.model.admin.dtos.ChannelDto;
import com.heima.model.admin.pojos.AdChannel;
import com.heima.model.common.dtos.PageResponseResult;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdChannelServiceImpl extends ServiceImpl<AdChannelMapper, AdChannel> implements AdChannelService {

    @Override
    public ResponseResult findByNameAndPage(ChannelDto dto) {
       /*
       //1.检查参数，如果参数为空，返回错误状态信息
        if (null == dto) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        dto.checkParam();

        //2.根据名称，模糊分页查询
        //创建分页对象，设置分页数量，每页条数
        Page page = new Page(dto.getPage(), dto.getSize());
        //创建查询条件对象
        LambdaQueryWrapper<AdChannel> lambdaQueryWrapper = new LambdaQueryWrapper();
        //判断频道名称是否不为空
        if (StringUtils.isNotBlank(dto.getName())) {
            //如果不为空，就对所有频道名称进行模糊查询(所有频道的名称，要查询的频道名称)
            //查询频道名称这个字段中，与目标名称匹配的值
            lambdaQueryWrapper.like(AdChannel::getName, dto.getName());
        }
        //按照分页对象进行分页条件查询,得到查询结果
        IPage result = page(page, lambdaQueryWrapper);

        //3.创建返回对象（分页信息）
        ResponseResult responseResult =
                new PageResponseResult(dto.getPage(), dto.getSize(), (int) result.getTotal());
        //将查询结果封装到集合中，将集合封装到返回对象中
                responseResult.setData(result.getRecords());
        return responseResult;*/
//
//        //首先要检查参数是否为空（dto对象是否为空，dto参数是否可行）
//        if (null==dto){
//            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
//        }
//        dto.checkParam();
//
//        //2.创建查询条件对象
//        LambdaQueryWrapper<AdChannel> lambdaQueryWrapper = new LambdaQueryWrapper();
//        //设置为模糊条件查询（首先要判断频道名称是否不为空）
//        //todo 这里检查参数是否不为空，与前面dto.checkParam()是否重复
//        if (StringUtils.isNotBlank(dto.getName())){
//            lambdaQueryWrapper.like(AdChannel::getName,dto.getName());
//        }
//        //按条件分页查询
//        Page page = new Page( dto.getPage(),dto.getSize());
//        IPage result =page(page,lambdaQueryWrapper);
//
//        //3.返回结果
//        ResponseResult responseResult = new PageResponseResult(dto.getPage(),dto.getSize(), (int) result.getTotal());
//        responseResult.setData(result.getRecords());
//        return responseResult;
/*
        //1.检查参数
        if (null==dto){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        dto.checkParam();

        //2.设置模糊查询条件
        //todo 这里为什么要加泛型<AdChannel>
        LambdaQueryWrapper<AdChannel>  queryWrapper = new LambdaQueryWrapper();
        queryWrapper.like(AdChannel::getName,dto.getName());
        //设置分页查询对象
        Page page = new Page(dto.getPage(),dto.getSize());
        IPage result = page(page, lambdaQuery());



        //3.返回结果
        ResponseResult responseResult = new PageResponseResult(dto.getPage(),dto.getSize(), (int) result.getTotal());
        responseResult.setData(result.getRecords());
        return responseResult;

*/
        /**
         * 需要完成的任务：根据名称与分页查找
         * 1.校验参数的有效性
         * 2.对数据进行查询
         * 3.封装结果并且返回
         */
        if (null == dto) {
            //返回一个错误状态
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //参数自行检查
        dto.checkParam();
        //创建分页对象
        Page page = new Page(dto.getPage(), dto.getSize());
        //创建条件查询对象
        LambdaQueryWrapper<AdChannel> queryWrapper = new LambdaQueryWrapper<>();
        //设置模糊查询返回以及匹配对象
        queryWrapper.like(AdChannel::getName, dto.getName());
        //根据分页参数，查询条件得到查询结果
        //todo 为什么这里IPage对象里面还有一个IPage
        IPage result = page(page, queryWrapper);
        //根据查询结果，得到对应的集合对象
        List records = result.getRecords();
        //包装结果对象，并且返回
        ResponseResult responseResult =
                new PageResponseResult(dto.getPage(), dto.getSize(), (int) result.getTotal());
        responseResult.setData(records);
        return responseResult;


    }

}