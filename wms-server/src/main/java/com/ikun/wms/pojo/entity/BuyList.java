package com.ikun.wms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 采购单
 * @TableName buy_list
 */
@TableName(value ="buy_list")
@Data
public class BuyList implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
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
    private LocalDateTime buyTime;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}