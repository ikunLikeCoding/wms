package com.ikun.wms.pojo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 规格单位表
 * @TableName unit
 */
@Data
public class Unit implements Serializable {
    /**
     * 
     */
    private Integer unitId;

    /**
     * 
     */
    private String unitName;

    /**
     * 
     */
    private String unitDesc;

    private static final long serialVersionUID = 1L;
}