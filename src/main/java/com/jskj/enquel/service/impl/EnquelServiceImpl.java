package com.jskj.enquel.service.impl;

import com.jskj.enquel.entity.UserDTO;
import com.jskj.enquel.service.EnquelService;
import org.springframework.stereotype.Service;

@Service
public class EnquelServiceImpl implements EnquelService {

    @Override
    public UserDTO getUser(int id) {
        System.out.println("one");
        if (1 == id) {
            UserDTO userDTO = new UserDTO("enquel","11");
            System.out.println("two");
            return userDTO;
        }
        System.out.println("null");
        return null;
    }
}
