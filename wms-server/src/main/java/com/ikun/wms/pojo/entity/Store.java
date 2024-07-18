package com.ikun.wms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 仓库表
 * @TableName store
 */
@TableName(value ="store")
@Data
public class Store implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer storeId;

    /**
     * 
     */
    private String storeName;

    /**
     * 
     */
    private String storeNum;

    /**
     * 
     */
    private String storeAddress;

    /**
     * 
     */
    private String concat;

    /**
     * 
     */
    private String phone;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}