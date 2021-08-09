package com.heima.wemedia.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.media.pojos.WmUser;
import com.heima.wemedia.mapper.WmUserMapper;
import org.springframework.stereotype.Service;

/**
 * @author 亚平
 */
@Service
public class WmUserServiceImpl extends ServiceImpl<WmUserMapper, WmUser>implements WmUserService {
}
