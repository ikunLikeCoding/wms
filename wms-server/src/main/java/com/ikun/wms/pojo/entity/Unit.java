package com.ikun.wms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 规格单位表
 * @TableName unit
 */
@TableName(value ="unit")
@Data
public class Unit implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer unitId;

    /**
     * 
     */
    private String unitName;

    /**
     * 
     */
    private String unitDesc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}