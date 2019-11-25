package com.jskj.enquel.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDTO {

    private String name;

    private String age;

    public UserDTO(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
