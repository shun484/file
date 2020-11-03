package com.apigateway.serivce;

import com.apigateway.entity.User;

public interface UserSerivce {

    String loginIndex(User user);

    //登录
    User getLogin(String userName, String password);
}
