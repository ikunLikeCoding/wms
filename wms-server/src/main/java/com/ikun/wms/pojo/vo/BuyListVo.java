package com.ikun.wms.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BuyListVo {
    private Integer buyId;

    /**
     *
     */
    private Integer productId;

    /**
     *
     */
    private Integer storeId;

    /**
     *
     */
    private Integer buyNum;

    /**
     *
     */
    private Integer factBuyNum;

    /**
     *
     */
    private LocalDateTime buyTime;

    /**
     *
     */
    private Integer supplyId;

    /**
     *
     */
    private Integer placeId;

    /**
     *
     */
    private String buyUser;

    /**
     *
     */
    private String phone;

    /**
     * 0 否 1 是
     */
    private String isIn;

    private String productName;//商品名称


    private String storeName;//仓库名称


    private String startTime;//搜索起始时间


    private String endTime;//搜索结束时间
}
