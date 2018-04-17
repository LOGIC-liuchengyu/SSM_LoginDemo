package com.todorex.daotest;


import com.todorex.BaseJunit4Test;
import com.todorex.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by rex on 2018/4/17.
 */

public class UserDaoTest extends BaseJunit4Test {
    // 注入Dao
    @Autowired
    private UserDao userDao;


    @Test   //标明是测试方法
    public void TestFindByUsername() {
        User user = userDao.findByUsername("rex");
        System.out.println(user);
    }
}



