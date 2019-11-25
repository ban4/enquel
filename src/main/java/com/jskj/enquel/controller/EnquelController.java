package com.jskj.enquel.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnquelController {

    @Value("${enquel.name}")
    private String name;

    @Value("${enquel.age}")
    private String age;

    @GetMapping("/getInfo/{id}")
    public String getInfo(@PathVariable int id){

        if (1 < id) {
            return "查询失败";
        }else {
            return "name: " + name + " --- age: " + age;
        }

    }

}
