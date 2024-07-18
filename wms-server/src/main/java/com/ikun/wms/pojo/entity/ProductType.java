package com.ikun.wms.pojo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 商品分类表
 * @TableName product_type
 */
@Data
public class ProductType implements Serializable {
    /**
     * 
     */
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

    private static final long serialVersionUID = 1L;
}