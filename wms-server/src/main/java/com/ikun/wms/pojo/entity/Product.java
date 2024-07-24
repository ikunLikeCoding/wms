package com.ikun.wms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 商品表
 * @TableName product
 */
@TableName(value ="product")
@Data
public class Product implements Serializable {
   /* *//**
     *
     *//*
    @TableId(type = IdType.AUTO)
    private Integer productId;

    *//**
     *
     *//*
    private Integer storeId;

    *//**
     *
     *//*
    private Integer brandId;

    *//**
     *
     *//*
    private String productName;

    *//**
     *
     *//*
    private String productNum;

    *//**
     *
     *//*
    private Integer productInvent;

    *//**
     *
     *//*
    private Integer typeId;

    *//**
     *
     *//*
    private Integer supplyId;

    *//**
     *
     *//*
    private Integer placeId;

    *//**
     *
     *//*
    private Integer unitId;

    *//**
     *
     *//*
    private String introduce;

    *//**
     * 0 下架 1 上架
     *//*
    private String upDownState;

    *//**
     *
     *//*
    private BigDecimal inPrice;

    *//**
     *
     *//*
    private BigDecimal salePrice;

    *//**
     *
     *//*
    private BigDecimal memPrice;

    *//**
     *
     *//*
    private LocalDateTime createTime;

    *//**
     *
     *//*
    private LocalDateTime updateTime;

    *//**
     *
     *//*
    private Integer createBy;

    *//**
     *
     *//*
    private Integer updateBy;

    *//**
     *
     *//*
    private String imgs;

    *//**
     *
     *//*
    private LocalDateTime productDate;

    *//**
     *
     *//*
    private LocalDateTime suppDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;*/
    @TableId(type = IdType.AUTO)
    private Integer productId;//商品id

    private Integer storeId;//商品所在仓库id
    private String storeName;//非表中字段 --商品所在仓库名称

    private Integer brandId;//商品所属品牌id
    private String brandName;//非表中字段 -- 商品所属品牌名称

    private String productName;//商品名称

    private String productNum;//商品编码

    private Integer productInvent;//商品库存

    private Integer typeId;//商品所属分类id
    private String typeName;//非表中字段 -- 商品所属分类名称

    private Integer supplyId;//商品供应商id
    private String supplyName;//非表中字段 -- 商品供应商名称

    private Integer placeId;//商品产地id
    private String placeName;//非表中字段 -- 商品产地名称

    private Integer unitId;//商品单位id
    private String unitName;//非表中字段 -- 商品单位名称

    private String introduce;//商品介绍

    private String upDownState;//商品上下架状态,1.上架,0.下架

    private Double inPrice;//商品进价

    private Double salePrice;//商品售价

    private Double memPrice;//商品会员价

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;//商品的创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;//商品的修改时间

    private Integer createBy;//创建商品的用户id

    private Integer updateBy;//修改商品的用户id

    private String imgs;//商品的图片地址

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date productDate;//商品的生产日期

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date suppDate;//商品的保质期

    private String isOverDate;//非表中字段 -- 商品是否过期,0未过期,1已过期

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}