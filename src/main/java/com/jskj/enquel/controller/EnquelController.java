package com.jskj.enquel.controller;

import com.jskj.enquel.entity.UserDTO;
import com.jskj.enquel.service.EnquelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnquelController {

    @Value("${enquel.name}")
    private String name;

    @Value("${enquel.age}")
    private String age;

    @Autowired
    private EnquelService enquelService;

    @GetMapping("/{id}")
    public String getInfo(@PathVariable int id){
        if (1 < id) {
            return "查询失败";
        }else {
            return "name: " + name + " --- age: " + age;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){

        if (1 == id){
            return "删除成功";
        }else {
            return "删除失败";
        }

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int id){

        UserDTO userDTO = enquelService.getUser(id);
        if (StringUtils.isEmpty(userDTO)){
            return new ResponseEntity<>(userDTO, new HttpHeaders(), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(userDTO, new HttpHeaders(), HttpStatus.OK);
        }

    }

}
