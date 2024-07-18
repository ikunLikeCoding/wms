package com.ikun.wms.pojo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 商品表
 * @TableName product
 */
@Data
public class Product implements Serializable {
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
    private Integer brandId;

    /**
     * 
     */
    private String productName;

    /**
     * 
     */
    private String productNum;

    /**
     * 
     */
    private Integer productInvent;

    /**
     * 
     */
    private Integer typeId;

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
    private Integer unitId;

    /**
     * 
     */
    private String introduce;

    /**
     * 0 下架 1 上架
     */
    private String upDownState;

    /**
     * 
     */
    private BigDecimal inPrice;

    /**
     * 
     */
    private BigDecimal salePrice;

    /**
     * 
     */
    private BigDecimal memPrice;

    /**
     * 
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 
     */
    private Integer createBy;

    /**
     * 
     */
    private Integer updateBy;

    /**
     * 
     */
    private String imgs;

    /**
     * 
     */
    private Date productDate;

    /**
     * 
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date suppDate;

    private static final long serialVersionUID = 1L;
}