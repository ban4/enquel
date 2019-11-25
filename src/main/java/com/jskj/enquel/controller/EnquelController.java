package com.jskj.enquel.controller;

import com.jskj.enquel.entity.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        if (1 == id) {
            UserDTO userDTO = new UserDTO("enquel","11");
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("X-Total-Count", String.valueOf(199));
            return new ResponseEntity<>(userDTO, responseHeaders, HttpStatus.OK);
        }else {
            UserDTO userDTO = new UserDTO("no","0");
            return new ResponseEntity<>(userDTO, new HttpHeaders(), HttpStatus.OK);
        }


    }

}
