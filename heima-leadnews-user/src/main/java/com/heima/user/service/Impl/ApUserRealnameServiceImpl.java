package com.heima.user.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.admin.dtos.AdUserDto;
import com.heima.model.common.dtos.PageResponseResult;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.user.dtos.AuthDto;
import com.heima.model.user.pojos.ApUserRealname;
import com.heima.user.mapper.ApUserRealnameMapper;
import com.heima.user.service.ApUserRealnameService;
import org.springframework.stereotype.Service;

/**
 * @author 亚平
 *
 */

@Service
public class ApUserRealnameServiceImpl
        extends ServiceImpl<ApUserRealnameMapper, ApUserRealname>
        implements ApUserRealnameService {
    @Override
    public ResponseResult loadListByStatus(AuthDto dto) {
        if(dto==null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        dto.checkParam();
        //创建查询条件
        LambdaQueryWrapper<ApUserRealname> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (dto.getStatus()!=null){
            lambdaQueryWrapper.eq(ApUserRealname::getStatus,dto.getStatus());
        }
        //创建分页对象
        IPage pageParam = new Page(dto.getPage(),dto.getSize());
        //进行分页条件查询
        IPage page = page(pageParam,lambdaQueryWrapper);

        //3.结果返回
        //创建分页结果返回对象
        PageResponseResult result  =  new PageResponseResult(dto.getPage(),dto.getSize(), (int) page.getSize());
        //放入数据
        result.setData(page.getRecords());
        return result;
    }
}
