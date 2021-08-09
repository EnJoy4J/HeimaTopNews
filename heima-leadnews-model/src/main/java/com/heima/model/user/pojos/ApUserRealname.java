package com.heima.model.user.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author 亚平
 */
@Data
@TableName("ap_user_realname")
public class ApUserRealname {

    /**
     *todo ?    java源码里有大量的类都有这么一个序列号。目的就是把java对象序列化而后进行保存。
     */
    private static final long serialVersionUID = 1L;

    /**
     *主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     *账号ID
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     *yong用户名称
     *
     *  */
    @TableField(value = "name")
    private String name;

    /**
     *资源名称
     */
    @TableField(value = "idno")
    private String idno;

    /**
     *正面照片
     */
    @TableField(value = "font_image")
    private String fontImage;

    /**
     *背面照片
     */
    @TableField(value = "back_image")
    private String backImage;

    /**
     *手持照片
     */
    @TableField(value = "hold_image")
    private String holdImage;

    /**
     *活体照片
     */
    @TableField(value = "live_image")
    private String liveImage;

    /**
     *状态信息
     *             0 创建中
     *             1 待审核
     *             2 审核失败
     *             9 审核通过
     */
    @TableField(value = "status")
    private short status;

    /**
     *  拒绝原因
     */
    @TableField("reason")
    private String reason;

    /**
     *  创建时间
     */
    @TableField("created_time")
    private Date createdTime;

    /**
     *   提交时间
     */
    @TableField("submited_time")
    private Date submitedTime;

    /**
     *  更新时间
     */
    @TableField("updated_time")
    private Date updatedTime;

}
