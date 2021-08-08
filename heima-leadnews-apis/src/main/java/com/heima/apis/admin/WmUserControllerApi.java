package com.heima.apis.admin;

import com.alibaba.nacos.client.utils.JSONUtils;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.media.pojos.WmUser;

/**
 * @author 亚平
 */
public interface WmUserControllerApi {
    /**
     * 保存自媒体用户
     * @param user
     * @return
     */
    public ResponseResult save(WmUser user);

    /**
     * 根据名称查找自媒体用户124
     * @param userName
     * @return
     */
    public WmUser findByName(String userName);

}
