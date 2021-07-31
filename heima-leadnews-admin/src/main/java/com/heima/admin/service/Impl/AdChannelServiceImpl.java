package com.heima.admin.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.admin.mapper.AdChannelMapper;
import com.heima.admin.service.AdChannelService;
import com.heima.model.admin.dtos.ChannelDto;
import com.heima.model.admin.pojos.AdChannel;
import com.heima.model.common.dtos.PageResponseResult;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.Date;
import java.util.List;

@Service
public class AdChannelServiceImpl extends ServiceImpl<AdChannelMapper, AdChannel> implements AdChannelService {


    /**
     * 需要完成的任务：根据名称与分页查找
     * 1.校验参数的有效性
     * 2.对数据进行查询
     * 3.封装结果并且返回
     */
    @Override
    public ResponseResult findByNameAndPage(ChannelDto dto) {


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
        if (StringUtils.isNotBlank(dto.getName())) {
            queryWrapper.like(AdChannel::getName, dto.getName());
        }
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

    /**
     * 添加频道
     * 1.判断频道是否为空
     * 2.保存频道
     *
     * @param adChannel
     * @return
     */
    @Override
    public ResponseResult insert(AdChannel adChannel) {
        //1.检查参数
        if (null == adChannel) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //2.保存结果
        adChannel.setCreatedTime(new Date());
        save(adChannel);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }


    /**
     * 1.检查参数
     * 2.修改频道
     *
     * @param adChannel
     * @return
     */
    @Override
    public ResponseResult update(AdChannel adChannel) {
        //1.检查参数
        if (null == adChannel || null == adChannel.getId()) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        updateById(adChannel);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);

    }

    /**
     * 删除频道
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteById(Integer id) {
        //1.检查参数(如果id为null)
        if (null==id){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //2.判断当前频道是否存在，是否有效
        AdChannel channel = getById(id);
        if (null==channel){
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }

        if (channel.getStatus()){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID,"频道有效，无法删除");
        }
        int a= 1/0;
        //3.删除频道
        removeById(id);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}