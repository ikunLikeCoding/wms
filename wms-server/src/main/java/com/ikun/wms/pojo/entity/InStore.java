package com.ikun.wms.pojo.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 入库单
 * @TableName in_store
 */
@Data
public class InStore implements Serializable {
    /**
     * 
     */
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

    private static final long serialVersionUID = 1L;
}