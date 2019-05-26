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
        return "login";
    }
    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}
