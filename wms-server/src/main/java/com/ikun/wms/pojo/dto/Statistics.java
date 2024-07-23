package com.ikun.wms.pojo.dto;

import lombok.Data;

@Data
public class Statistics {

    private Integer storeId;//仓库id

    private String storeName;//仓库名称

    private Integer totalInvent;//仓库商品库存数
}
