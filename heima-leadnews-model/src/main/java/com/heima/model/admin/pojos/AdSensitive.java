package com.heima.model.admin.pojos;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("ad_sensitive")
public class AdSensitive implements Serializable {

    /**
     * todo 什么用？
     */
    private static final long  serialVersionUID = 1L;

    /**
     * 主键id，自增
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 敏感词
     */
    @TableField(value = "sensitives")
    private String sensitives;

    /**
     * 创建时间
     */
    @TableField(value = "created_time")
    private Date created_time;

}
