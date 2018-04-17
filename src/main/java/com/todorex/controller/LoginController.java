package com.todorex.controller;

import com.todorex.entity.User;
import com.todorex.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by rex on 2018/4/16.
 */
@Controller
// 设置Session,保证session存在这个user作为判断对象
@SessionAttributes("user")
public class LoginController {
    // 获得日志对象
    Logger logger = Logger.getLogger(LoginController.class);

    // 自动注入Service对象
    @Autowired
    private UserService userService;


    // 正常访问login页面
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    // 跳转成功页面
    @RequestMapping("/success")
    public String success() {
        return "success";
    }

    // 跳转失败页面
    @RequestMapping("/fail")
    public String fail() {
        return "fail";
    }

    // 验证登录名密码(需要用Post方式传输)
    @RequestMapping(value = "/checkLogin",method = RequestMethod.POST)
    public String checkLogin(User user, Model model) {
        // 调用Service方法进行检查
        user = userService.checkLogin(user.getUsername(),user.getPassword());
        if (user != null) {
            // 日志记录用户登录
            logger.info(user.getUsername()+"在"+new Date() + "登录过!");
            // 如果数据库存在该对象，则将该对象添加到Session并调整到成功页面
            model.addAttribute("user",user);
            return "redirect:/success";
        } else {
            // 否则调转到失败页面（真实应用时，应该使用Ajax无刷新技术来提高用户体验度）
            // 页面重定向（URL会改变，客户端行为，两次http）；
            return "redirect:/fail";
            // 页面转发（URL不会会改变，服务端行为，一次http）
            // return "fail";

        }
    }

    // 注销
    @RequestMapping("/outLogin")
    public String outLogin(HttpSession httpSession) {
        // 通过session.invalidata()方法来注销当前的session
        httpSession.invalidate();
        return "redirect:/login";
    }
}
