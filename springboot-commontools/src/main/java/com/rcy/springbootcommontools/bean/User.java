package com.rcy.springbootcommontools.bean;

/**
 * @description: User对象  用于排序
 * @author: rencaiyu
 * @create: 2019年12月18日 21:27
 **/
public class User {
    private String userName;
    private int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
