package com.ikun.wms.pojo.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

/**
 * 出库单
 * @TableName out_store
 */
@TableName(value ="out_store")
@Data
public class OutStore implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}