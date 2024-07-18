package com.ikun.wms.pojo.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 采购单
 * @TableName buy_list
 */
@Data
public class BuyList implements Serializable {
    /**
     * 
     */
    private Integer buyId;

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
    private Integer buyNum;

    /**
     * 
     */
    private Integer factBuyNum;

    /**
     * 
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date buyTime;

    /**
     * 
     */
    private Integer supplyId;

    /**
     * 
     */
    private Integer placeId;

    /**
     * 
     */
    private String buyUser;

    /**
     * 
     */
    private String phone;

    /**
     * 0 否 1 是
     */
    private String isIn;

    private static final long serialVersionUID = 1L;
}