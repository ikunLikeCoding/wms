package com.ikun.wms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@MapperScan("com.ikun.wms.mapper")
public class WmsApplication {

    public static void main(String[] args) {

        SpringApplication.run(WmsApplication.class,args);
    }

}
