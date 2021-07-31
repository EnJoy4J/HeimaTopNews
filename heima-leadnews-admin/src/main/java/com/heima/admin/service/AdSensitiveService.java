package com.heima.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.admin.dtos.SensitiveDto;
import com.heima.model.admin.pojos.AdSensitive;
import com.heima.model.common.dtos.ResponseResult;

public interface AdSensitiveService extends IService<AdSensitive> {


    /**
     * 根据名称分页查找敏感词
     * @param sensitiveDto
     * @return
     */
    public ResponseResult list(SensitiveDto sensitiveDto);

    /**
     * 添加敏感词
     * @param adSensitive
     * @return
     */
    public ResponseResult insert(AdSensitive adSensitive);

    /**
     * 根据id删除敏感词
     * @param id
     * @return
     */
    public ResponseResult deleteById(Integer id);

    /**
     * 修改敏感词
     * @param adSensitive
     * @return
     */
    public ResponseResult update(AdSensitive adSensitive);




}
