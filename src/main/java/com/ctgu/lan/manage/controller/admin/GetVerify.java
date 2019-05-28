package com.ctgu.lan.manage.controller.admin;

import com.ctgu.lan.manage.model.Admin;
import com.ctgu.lan.manage.model.dto.CheckAdminWhenGetVerify;
import com.ctgu.lan.manage.service.AdminRepositoryService;
import com.ctgu.lan.manage.utils.EmailUtil;
import com.ctgu.lan.manage.utils.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 检测要找回密码的人是否合格
 * @auther lan_wh
 * @create 2019-05-27 19:30
 * @ClassName GetVerify
 * @Version 1.0.0
 */
@Controller
public class GetVerify {
    @Autowired
    private AdminRepositoryService adminRepositoryService;

    @RequestMapping("/getVerify")
    @ResponseBody
    public CheckAdminWhenGetVerify checkAdmin(@RequestBody(required = false) CheckAdminWhenGetVerify checkAdminWhenGetVerify){
        Admin admin = adminRepositoryService.findByEmailAndPhoneNumber(checkAdminWhenGetVerify.getEmail(),
                checkAdminWhenGetVerify.getPhoneNumber());
        if( admin != null ){
            String from = "1090230661@qq.com";
            String Authorization = "kycksukluwltiggb";
            String verify = RandomString.randStr(6);
            System.out.println(verify);
            System.out.println(admin.toString());
            EmailUtil.qqEmail(from, checkAdminWhenGetVerify.getEmail(), Authorization,verify);
            checkAdminWhenGetVerify.setVerify(verify);
        }
        else{
            checkAdminWhenGetVerify.setVerify("error");
        }
        return checkAdminWhenGetVerify;
    }

}
