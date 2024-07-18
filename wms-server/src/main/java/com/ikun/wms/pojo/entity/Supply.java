package com.ikun.wms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 供货商
 * @TableName supply
 */
@TableName(value ="supply")
@Data
public class Supply implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer supplyId;

    /**
     * 
     */
    private String supplyNum;

    /**
     * 
     */
    private String supplyName;

    /**
     * 
     */
    private String supplyIntroduce;

    /**
     * 
     */
    private String concat;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private String address;

    /**
     * 0:可用  1:不可用
     */
    private String isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}