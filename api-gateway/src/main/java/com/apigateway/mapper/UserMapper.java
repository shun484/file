package com.apigateway.mapper;

import com.apigateway.entity.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    User getLogin(@Param("userName") String userName,@Param("password") String password);
}
