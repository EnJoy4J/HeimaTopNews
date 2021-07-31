package com.heima.apis.admin;

import com.heima.model.admin.dtos.SensitiveDto;
import com.heima.model.admin.pojos.AdSensitive;
import com.heima.model.common.dtos.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "敏感词管理",tags = "sensitive",description = "敏感词管理API")
public interface AdSensitiveControllerApi {


    /**
     * 根据名称分页查找敏感词
     * @param sensitiveDto
     * @return
     */
    @ApiOperation("根据名称分页查找敏感词")
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
