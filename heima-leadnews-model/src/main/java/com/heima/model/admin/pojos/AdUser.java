package com.heima.model.admin.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@TableName("ad_user")
public class AdUser implements Serializable {//为什么要实现序列化
    //todo??这是什么
    private static final long serialVersionUID = 1L;

    //todo 主键为什么不用注解？
    private Integer id;// '主键'

    @TableField("name")
    private String name;  //'登录用户名',

    @TableField("password")
    private String password;  //'登录密码',

    @TableField("salt")
    private String salt;  //'盐',

    @TableField("nickname")
    private String nickname;  //'昵称',

    @TableField("image")
    private String image;  //'头像',

    @TableField("phone")
    private String phone;  //'手机号',

    @TableField("status")
    private String status;  //'状态

    @TableField("email")
    private String email;     //'邮箱',

    @TableField("login_time")
    private Date loginTime;  //'最后一次登录时间',

    @TableField("created_time")
    private Date createdTime;  //'创建时间'
}
