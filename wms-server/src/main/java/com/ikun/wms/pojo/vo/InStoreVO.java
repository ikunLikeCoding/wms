package com.ikun.wms.pojo.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: yiwang
 * @Date: 2024/7/22
 */
@Data
public class InStoreVO {
    //入库单id
    private Integer insId;

    //仓库id
    private Integer storeId;
    //商品id
    private Integer productId;
    //入库数量
    private Integer inNum;
    //创建入库单的用户id
    private Integer createBy;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    //创建时间
    private Date createTime;
    //是否入库,1.是,0.否
    private Integer isIn;

    private String storeName;
    //商品名称
    private String productName;


    //商品入库价格
    private BigDecimal inPrice;
}
