package com.ikun.wms.pojo.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

/**
 * 入库单
 * @TableName in_store
 */
@TableName(value ="in_store")
@Data
public class InStore implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer insId;

    /**
     * 
     */
    private Integer storeId;

    /**
     * 
     */
    private Integer productId;

    /**
     * 
     */
    private Integer inNum;

    /**
     * 
     */
    private Integer createBy;

    /**
     * 
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 0 否 1 是
     */
    private String isIn;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}