package com.ikun.wms.pojo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 出库单
 * @TableName out_store
 */
@Data
public class OutStore implements Serializable {
    /**
     * 
     */
    private Integer outsId;

    /**
     * 
     */
    private Integer productId;

    /**
     * 
     */
    private Integer storeId;

    /**
     * 
     */
    private Integer tallyId;

    /**
     * 
     */
    private BigDecimal outPrice;

    /**
     * 
     */
    private Integer outNum;

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
    private String isOut;

    private static final long serialVersionUID = 1L;
}