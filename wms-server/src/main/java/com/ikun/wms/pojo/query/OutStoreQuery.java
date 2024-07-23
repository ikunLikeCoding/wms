package com.ikun.wms.pojo.query;

import lombok.Data;

/**
 * @Author: yiwang
 * @Date: 2024/7/23
 */

@Data
public class OutStoreQuery extends BaseQuery{
    private String productName;
    private String startTime;
    private String storeId;
    private String endTime;
    private Integer isOut;
}
