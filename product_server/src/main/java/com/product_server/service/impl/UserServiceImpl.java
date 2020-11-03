package com.product_server.service.impl;

import com.product_server.model.User;
import com.product_server.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private static final List<User> map = new ArrayList<>();

    static {
        User user = new User(1,"admin","123456");
        User user1 = new User(2,"bjs","123456");
        User user2 = new User(3,"sds","123456");
        map.add(user);
        map.add(user1);
        map.add(user2);
    }



}
