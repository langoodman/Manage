package com.ctgu.lan.manage.controller;

import com.ctgu.lan.manage.model.Admin;
import com.ctgu.lan.manage.model.dto.CheckAdminWhenGetVerify;
import com.ctgu.lan.manage.service.AdminRepositoryService;
import com.ctgu.lan.manage.service.StaffRepositoryService;
import com.ctgu.lan.manage.service.UserRepositoryService;
import com.ctgu.lan.manage.utils.EmailUtil;
import com.ctgu.lan.manage.utils.MD5Util;
import com.ctgu.lan.manage.utils.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-05-28 14:21
 * @ClassName AdminController
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminRepositoryService adminRepositoryService;

    @Autowired
    private UserRepositoryService userRepositoryService;

    @Autowired
    private StaffRepositoryService staffRepositoryService;

    /**
     * 跳转到修改密码界面
     * @return
     */
    @RequestMapping("/changePassword")
    public String changePassword(){
        return "admin/changePassword";
    }
    /**
     * 管理员登录
     * @param phoneNumber
     * @param passWord
     * @param session
     * @param modelMap
     * @return
     */
    @RequestMapping("/loginInfo")
    public String adminLogin(@RequestParam("phoneNumber")String phoneNumber ,
                             @RequestParam("passWord")String passWord,
                             HttpSession session,
                             ModelMap modelMap){
        String cryptPassWord = MD5Util.crypt(passWord);
        System.out.println(cryptPassWord);
        Admin admin = adminRepositoryService.findByPhoneNumberAndPassWord(phoneNumber , cryptPassWord);
        if( admin != null ){
            System.out.println(admin.toString());
            session.setAttribute("lastTimeString",admin.getLastTime());
            session.setAttribute("admin",admin);
            Date nowTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowTimeString = sdf.format(nowTime);
            admin.setLastTime(nowTimeString);
            session.setAttribute("nowTimeString",nowTimeString);
            adminRepositoryService.modifyNowTimeById(nowTimeString,admin.getId());
            Long userCount = userRepositoryService.countUser();
            Long staffCount = staffRepositoryService.countStaff();
            session.setAttribute("userCount",userCount);
            session.setAttribute("staffCount",staffCount);
//            return "redirect:/login";
            return "index";
        }
        else{
//            session.setAttribute("loginErrorMsg","电话号码不存在或密码错误");
            modelMap.addAttribute("loginErrorMsg","电话号码不存在或密码错误");
            return "admin/login";
        }
    }

    /**
     * 获取验证码
     * @param checkAdminWhenGetVerify
     * @param session
     * @return
     */
    @RequestMapping("/getVerify")
    @ResponseBody
    public CheckAdminWhenGetVerify checkAdmin(@RequestBody(required = false) CheckAdminWhenGetVerify checkAdminWhenGetVerify,
                                              HttpSession session){
        Admin admin = adminRepositoryService.findByEmailAndPhoneNumber(checkAdminWhenGetVerify.getEmail(),
                checkAdminWhenGetVerify.getPhoneNumber());
        if( admin != null ){
            String from = "1090230661@qq.com";
            String Authorization = "kycksukluwltiggb";
            String verify = RandomString.randStr(6);
            System.out.println(verify);
            System.out.println(admin.toString());
            session.setAttribute("admin",admin);
            EmailUtil.qqEmail(from, checkAdminWhenGetVerify.getEmail(), Authorization,verify);
            checkAdminWhenGetVerify.setVerify(verify);
        }
        else{
            checkAdminWhenGetVerify.setVerify("error");
        }
        return checkAdminWhenGetVerify;
    }

    /**
     * 管理员修改密码
     * @param newPassWord
     * @param session
     * @return
     */
    @RequestMapping("/changePass")
    public String changePass(@RequestParam("newPassWord")String newPassWord,
                             HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        String cryptPassWord = MD5Util.crypt(newPassWord);
        adminRepositoryService.modifyPassWordById(cryptPassWord,admin.getId());
        session.removeAttribute("admin");
        return "admin/login";
    }

    /**
     * 管理员退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String adminLogout(HttpSession session){
        session.invalidate();
        return "admin/login";
    }

    @RequestMapping("/updateInfo")
    public String updateAdminInfo(Admin admin , HttpSession session){
        Admin sessionAdmin = (Admin)session.getAttribute("admin");
        sessionAdmin.setAge(admin.getAge());
        sessionAdmin.setName(admin.getName());
        sessionAdmin.setEmail(admin.getEmail());
        Admin admin1 = adminRepositoryService.updateAdminInfo(sessionAdmin);
        session.setAttribute("admin",sessionAdmin);
        System.out.println(admin1.toString());
        return "html/welcome";
    }
}
