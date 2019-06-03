package com.ctgu.lan.manage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ctgu.lan.manage.model.User;
import com.ctgu.lan.manage.service.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-02 15:58
 * @ClassName UserController
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepositoryService userRepositoryService;

    /**
     * 获得会员总数
     * @return
     */
    @RequestMapping("/getUserDataCount")
    @ResponseBody
    public String getUserDataCount(){
        long count = userRepositoryService.countUser();
        return String.valueOf(count);
    }


    /**
     * 会员分页查询
     * @param startPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/getUserData")
    @ResponseBody
    public List<User> getUserData(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                  @RequestParam(value = "PageSize", required = false, defaultValue = "10") Integer pageSize){
        Page<User> users = userRepositoryService.findAll(PageRequest.of(startPage - 1, pageSize));
        List<User> userList = users.getContent();
//        for( User user:userList){
//            System.out.println(user.toString());
//        }
        return userList;
    }


    /**
     * 看进行的是什么操作
     * @param user
     * @param attributes
     * @return
     */
    @RequestMapping("/operationUser")
    public String operationTeacher(User user, RedirectAttributes attributes){
        if(user.getId() == null){
            attributes.addFlashAttribute("adminUser", user);
            return "redirect:/user/addUserInfo";
        }else {
            attributes.addFlashAttribute("adminUser", user);
            return "redirect:/user/updateUserInfo";
        }
    }

    /**
     * 添加一个会员
     * @param user
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/addUserInfo")
    @ResponseBody
    public String addOneTeacher(@ModelAttribute("adminUser")User user , Model model , HttpSession session ){
        if( userRepositoryService.findByPhoneNumber(user.getPhoneNumber()) != null ){
            model.addAttribute("manageUserMsg", "该会员已存在!");
            return "0";
        }
        else {
            Date nowTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowTimeString = sdf.format(nowTime);
            user.setSignTime(nowTimeString);
            userRepositoryService.addUserInfo(user);
            model.addAttribute("manageUserMsg", "增加成功!");
            return "1";
        }
    }

    /**
     * 修改会员的信息
     * @param model
     * @param session
     * @param user
     * @return
     */
    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public String updateOneTeacher( Model model , HttpSession session ,@ModelAttribute("adminUser") User user ){
        if( userRepositoryService.findByPhoneNumber(user.getPhoneNumber()) == null ){
            model.addAttribute("manageUserMsg", "该会员已存在!");
            return "0";
        }
        else {
            userRepositoryService.updateUserInfo(user);
            model.addAttribute("manageUserMsg", "修改成功!");
            return "1";
        }
    }

    /**
     * 删除会员的信息
     * @param model
     * @param session
     * @param id
     * @return
     */
    @RequestMapping("/delUser")
    @ResponseBody
    public String deleOneTeacher( Model model , HttpSession session,
                                  @RequestParam("id") Integer id ){
        if( userRepositoryService.findOneById(id) == null ){
            model.addAttribute("manageUserMsg", "该会员不存在!");
            return "0";
        }
        else {
            userRepositoryService.deleUserById(id);
            model.addAttribute("manageUserMsg", "删除成功!");
            return "1";
        }
    }

    /**
     * 通过电话号码查询
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("/findUserByPhoneNumber")
    @ResponseBody
    public User findUserByPhoneNumber(@RequestBody(required = false) User user,
                                              HttpSession session){
        User findUser = userRepositoryService.findByPhoneNumber(user.getPhoneNumber());
        if( findUser == null ){
            user.setName("errorFind");
            return user;
        }
        return findUser;
    }
}
