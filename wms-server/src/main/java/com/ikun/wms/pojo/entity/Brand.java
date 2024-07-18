package com.ikun.wms.pojo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 品牌
 * @TableName brand
 */
@Data
public class Brand implements Serializable {
    /**
     * 
     */
    private Integer brandId;

    /**
     * 
     */
    private String brandName;

    /**
     * 
     */
    private String brandLeter;

    /**
     * 
     */
    private String brandDesc;

    private static final long serialVersionUID = 1L;
}