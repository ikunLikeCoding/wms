package com.ikun.wms.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yiwang
 * @Date: 2024/7/23
 */
@Data
public class ProductTypeTreeDTO implements Serializable {
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


    private List<ProductTypeTreeDTO> children;
}
