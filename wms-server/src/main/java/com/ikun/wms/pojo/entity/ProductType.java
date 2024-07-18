package com.ikun.wms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 商品分类表
 * @TableName product_type
 */
@TableName(value ="product_type")
@Data
public class ProductType implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer typeId;

    /**
     * 
     */
    private Integer parentId;

    /**
     * 
     */
    private String typeCode;

    /**
     * 
     */
    private String typeName;

    /**
     * 
     */
    private String typeDesc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}