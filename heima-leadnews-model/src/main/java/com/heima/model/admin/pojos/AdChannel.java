package com.heima.model.admin.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 频道信息表
 * </p>
 * 这个类的主要是拿来跟数据库中的表和字段 进行对应
 * @author itheima
 */
@Data
@TableName("ad_channel")
public class AdChannel implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键id、自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 频道名称
     * 虽然字段名称相同，为了保持良好的习惯，还是要写一遍
     */
    @TableField("name")
    private String name;

    /**
     * 频道描述
     */
    @TableField("description")
    private String description;

    /**
     * 是否默认频道
     * 数据库字段有下划线，成员属性中没有的（不一致的），需要加TableField加以对应
     */
    @TableField("is_default")
    private Boolean isDefault;

    @TableField("status")
    private Boolean status;

    /**
     * 默认排序
     */
    @TableField("ord")
    private Integer ord;

    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;

}