package com.heima.admin.controller.v1;

import com.heima.admin.service.AdChannelService;
import com.heima.apis.admin.AdChannelControllerApi;
import com.heima.model.admin.dtos.ChannelDto;
import com.heima.model.admin.pojos.AdChannel;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;


@RestController
@RequestMapping("/api/v1/channel")
public class AdChannelController implements AdChannelControllerApi {
    @Autowired
    private AdChannelService adChannelService;

    /**
     * 根据名称分页查找
     * @param dto
     * @return
     */
    @PostMapping("/list")
    @Override
    public ResponseResult findByNameAndPage(@RequestBody ChannelDto dto) {
        return adChannelService.findByNameAndPage(dto);
    }

    /**
     * 添加频道
     * @param adChannel
     * @return
     */
    @PostMapping("/save")
    @Override
    public ResponseResult save(@RequestBody AdChannel adChannel) {
        return adChannelService.insert(adChannel);
    }


    /**
     * 修改频道
     * @param adChannel
     * @return
     */
    @PostMapping("/update")
    @Override
    public ResponseResult update(@RequestBody AdChannel adChannel) {
        return adChannelService.update(adChannel);
    }


    @GetMapping("/del/{id}")
    @Override
    public ResponseResult deleteById(@PathVariable("id") Integer id) {
        return adChannelService.deleteById(id);
    }


}
