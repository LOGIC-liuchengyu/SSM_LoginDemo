package com.todorex.daotest;

import com.todorex.entity.User;

/**
 * Created by rex on 2018/4/16.
 */
public interface UserDao {
    /**
     * 用于匹配密码
     * @param username 用户名
     * @return
     */
    User findByUsername(String username);
}
