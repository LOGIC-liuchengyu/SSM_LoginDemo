package com.todorex;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试基类
 * Created by rex on 2018/4/17.
 */

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
// 导入多个配置文件
@ContextConfiguration(locations={"classpath:spring/spring-*.xml","classpath:mybatis-config.xml"}) //加载配置文件
//所有继承该类的测试类都会遵循该配置

//这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
//@Transactional

// 这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"）
// 指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！
// @TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BaseJunit4Test {
}