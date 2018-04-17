package com.todorex.service.impl;

import com.todorex.daotest.UserDao;
import com.todorex.entity.User;
import com.todorex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService接口实现类
 * Created by rex on 2018/4/16.
 */
@Service
public class UserServiceImpl implements UserService {

    // 利用mybatis-config文件自动注入一些Dao类
    @Autowired
    private UserDao userDao;

    /**
     * 具体校验登录业务
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User checkLogin(String username, String password) {
        User user = userDao.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
