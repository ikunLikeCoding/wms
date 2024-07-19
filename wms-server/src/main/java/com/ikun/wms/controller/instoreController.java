package com.ikun.wms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instore")
public class InstoreController {
    @RequestMapping("/instore")
    public String Instore(){
        return "instore";
    }

}
