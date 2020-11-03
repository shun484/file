package com.apigateway.entity;

/**
 * Description:
 * Auth: Frank
 * Date: 2017-11-06
 * Time: 上午 10:49
 */
public class User {
    private Long id;
    private String userName; //用户
    private String userPassword; //密码
    private String image;  //头像
    private Integer UserType;  //类型


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getUserType() {
        return UserType;
    }

    public void setUserType(Integer userType) {
        UserType = userType;
    }
}
