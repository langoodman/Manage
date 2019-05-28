package com.ctgu.lan.manage.controller.admin;

import com.ctgu.lan.manage.model.Admin;
import com.ctgu.lan.manage.model.dto.CheckAdminWhenGetVerify;
import com.ctgu.lan.manage.service.AdminRepositoryService;
import com.ctgu.lan.manage.utils.EmailUtil;
import com.ctgu.lan.manage.utils.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 检测要找回密码的人是否合格
 * @auther lan_wh
 * @create 2019-05-27 19:30
 * @ClassName GetVerify
 * @Version 1.0.0
 */
@RestController
public class GetVerify {
    @Autowired
    private AdminRepositoryService adminRepositoryService;

    @RequestMapping("/getVerify")
    public String checkAdmin(@RequestBody CheckAdminWhenGetVerify checkAdminWhenGetVerify){
        Admin admin = adminRepositoryService.findByEmailAndPhoneNumber(checkAdminWhenGetVerify.getEmail(),
                checkAdminWhenGetVerify.getPhoneNumber());
        if( admin != null ){
            String from = "1090230661@qq.com";
            String Authorization = "kycksukluwltiggb";
            String verify = RandomString.randStr(6);
            System.out.println(verify);
            System.out.println(admin.toString());
//            EmailUtil.qqEmail(from, email, Authorization,verify);
            return verify;
//            return "1";
        }
        else return "0";
    }

}
