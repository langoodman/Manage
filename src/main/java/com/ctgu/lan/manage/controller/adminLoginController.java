package com.ctgu.lan.manage.controller;

import com.ctgu.lan.manage.utils.MD5Util;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-05-25 16:45
 * @ClassName adminLoginController
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/admin")
public class adminLoginController {
    @RequestMapping("/login")
    public void adminLogin(@RequestParam("phoneNumber")String phoneNumber ,
                           @RequestParam("passWord")String passWord, Model model){
        String cryptPassWord = MD5Util.crypt(passWord);
        System.out.println(cryptPassWord);
        model.addAttribute("loginErrorMsg","密码错误");
    }

}
