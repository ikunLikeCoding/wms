package com.ikun.wms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 商品表
 * @TableName product
 */
@TableName(value ="product")
@Data
public class Product implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
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
    private LocalDateTime createTime;

    /**
     * 
     */
    private LocalDateTime updateTime;

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
    private LocalDateTime productDate;

    /**
     * 
     */
    private LocalDateTime suppDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}