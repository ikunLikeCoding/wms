package com.ikun.wms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 产地
 * @TableName place
 */
@TableName(value ="place")
@Data
public class Place implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer placeId;

    /**
     * 
     */
    private String placeName;

    /**
     * 
     */
    private String placeNum;

    /**
     * 
     */
    private String introduce;

    /**
     * 0:可用  1:不可用
     */
    private String isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}