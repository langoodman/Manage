package com.ctgu.lan.manage.controller.admin;

import com.ctgu.lan.manage.model.Admin;
import com.ctgu.lan.manage.service.AdminRepositoryService;
import com.ctgu.lan.manage.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-05-25 16:45
 * @ClassName Login
 * @Version 1.0.0
 */
@Controller
public class Login {

    @Autowired
    private AdminRepositoryService adminRepositoryService;

    /**
     * 管理员登录
     * @param phoneNumber
     * @param passWord
     * @param model
     * @return
     */
    @RequestMapping("/adminLogin")
    public String adminLogin(@RequestParam("phoneNumber")String phoneNumber ,
                             @RequestParam("passWord")String passWord, Model model){
        String cryptPassWord = MD5Util.crypt(passWord);
        System.out.println(cryptPassWord);
        Admin admin = adminRepositoryService.findByPhoneNumberAndPassWord(phoneNumber , cryptPassWord);
        if( admin != null ){
            System.out.println(admin.toString());
            return "login";
        }
        else{
            model.addAttribute("loginErrorMsg","电话号码不存在或密码错误");
            return "login";
        }
    }


}
