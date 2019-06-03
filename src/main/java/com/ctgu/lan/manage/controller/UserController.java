package com.ctgu.lan.manage.controller;

import java.util.List;

import com.ctgu.lan.manage.model.User;
import com.ctgu.lan.manage.service.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        for( User user:userList){
            System.out.println(user.toString());
        }
        return userList;
    }
}
