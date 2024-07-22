package com.ikun.wms.pojo.query;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @Author: yiwang
 * @Date: 2024/7/22
 */
@Data
public class InStoreQuery extends BaseQuery{
    private String productName;
    private String startTime;
    private String endTime;
    private Integer storeId;
}
