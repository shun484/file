package com.apigateway.serivce.impl;

import com.apigateway.entity.User;
import com.apigateway.serivce.UserSerivce;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserSerivceImpl implements UserSerivce {


    public static final Map<Long, User> hashMap = new HashMap<>();

   /* static {
        User user = new User(1L,"admin","123456");
        hashMap.put(user.getId(),user);
    }*/


    @Override
    public String loginIndex(User user) {
       /* Collection<User> collection = hashMap.values();

        List<User> list = new ArrayList<>(collection);

        List<String> userList = new ArrayList<>();

        list.forEach( lista ->{

            String name = lista.getName();
            String pwd = lista.getPwd();

            if(user.getName().equals(name) && user.getPwd().equals(pwd)){
                try {
                    String token = TokenUtil.getToken(user);
                    userList.add(token);
                }catch (Exception e){

                }
            }

        });

        String out = "";
        if(list.size() >0){
            out = userList.get(0);
        }*/
        return null;
    }

    @Override
    public User getLogin(String userName, String password) {

       // return mapper.getLogin(userName,password);
        return null;
    }
}
