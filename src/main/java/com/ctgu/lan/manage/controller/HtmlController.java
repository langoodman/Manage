package com.ctgu.lan.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-01 10:22
 * @ClassName HtmlController
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/html")
public class HtmlController {

    /**
     * 后台主页
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome(){
        return "html/welcome";
    }

    /**
     * 管理员修改个人信息
     * @return
     */
    @RequestMapping("/adminEditInfo")
    public String adminEditInfo(){
        return "html/adminEditInfo";
    }

    /**
     * 会员管理页面
     * @return
     */
    @RequestMapping("/userManage")
    public String userManage(){
        return "html/userManage";
    }

    /**
     * 跳转员工管理页面
     * @return
     */
    @RequestMapping("/staffManage")
    public String staffManage(){
        return "html/staffManage";
    }

    /**
     * 跳转药店管理页面
     * @return
     */
    @RequestMapping("/pharmacyManage")
    public String pharmacyManage(){
        return "html/pharmacyManage";
    }

    /**
     * 跳转药品管理页面
     * @return
     */
    @RequestMapping("/medicineManage")
    public String medicineManage(){
        return "html/medicineManage";
    }
}
