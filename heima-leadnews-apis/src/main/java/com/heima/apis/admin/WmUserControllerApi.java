package com.heima.apis.admin;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.media.pojos.WmUser;

/**
 * @author 亚平
 */
public interface WmUserControllerApi {
    /**
     * 保存自媒体用户
     * @param Wmuser
     * @return
     */
    public ResponseResult save(WmUser Wmuser);

    /**
     * 根据名称查找自媒体用户
     * @param name
     * @return
     */
    public WmUser findByName(String name);
}
