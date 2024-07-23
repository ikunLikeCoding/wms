package com.ikun.wms.pojo.query;

import lombok.Data;

@Data
public class StoreQuery extends BaseQuery{
    private int storeId;
    private String storeName;
    private String storeAddress;
    private String concat;
    private String phone;
}
