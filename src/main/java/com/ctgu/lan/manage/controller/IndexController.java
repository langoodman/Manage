package com.ctgu.lan.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-05-25 18:09
 * @ClassName IndexController
 * @Version 1.0.0
 */
@Controller
public class IndexController {

    /**
     * 将登录页面设置为项目的首页
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "admin/login";
    }
    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "admin/login";
    }

    /**
     * 跳转找回密码页面
     * @return
     */
    @RequestMapping("/findPassword")
    public String findPassword(){
        return "admin/findPassword";
    }

    /**
     * 跳转到修改密码界面
     * @return
     */
    @RequestMapping("/changePassword")
    public String changePassword(){
        return "admin/changePassword";
    }

}
