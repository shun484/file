package com.apigateway.controller;

import com.apigateway.entity.User;
import com.apigateway.serivce.UserSerivce;
import com.apigateway.utils.ResponseCode;
import com.apigateway.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/gateway")
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

    //登录成功
    @RequestMapping("/loginIndex")
    public String a(){
        return "userController/index";
    }
    /**
     * <p>登录</p>
     * @param user
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResponseData login(@RequestBody User user){

        ResponseData responseData = new ResponseData();

        try {
          User users = serivce.getLogin(user.getUserName(),user.getUserPassword());
          if(users !=null){
              responseData.setCode(ResponseCode.OK);
              responseData.setMessage("登录成功");
              responseData.setData("/api/v1/gateway/loginIndex");
          }else{
              responseData.setCode("056");
              responseData.setMessage("用户名或密码错误");
          }

        }catch (Exception e){
            responseData.setCode(ResponseCode.ERR_CODE_UNKNOW_ERROR);
            responseData.setMessage("内部错误");
            e.printStackTrace();
        }

        return responseData;
    }


}
