package com.todorex.service;

import com.todorex.entity.User;

/**
 *  定义UserService接口（抽象出方法），一定要符合设计原则（参照设计模式，高内聚，低耦合）
 * Created by rex on 2018/4/16.
 */
public interface UserService {
    /**
     * 检验登入的用户名密码是否正确
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username, String password);
}
