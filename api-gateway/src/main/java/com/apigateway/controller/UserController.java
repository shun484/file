package com.apigateway.controller;

import com.apigateway.entity.User;
import com.apigateway.serivce.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class UserController {

    @Autowired
    private UserSerivce serivce;

    @RequestMapping("/index")
    public String UserFind(User user, Model m){
        try {
            String users = serivce.loginIndex(user);
            if(StringUtils.isEmpty(users)){
                return "index";
            }
            System.out.println(users);
            m.addAttribute("token",users);
            return "loginIndex";
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "loginIndex";
    }
}
