package com.ctgu.lan.manage.controller;

import com.ctgu.lan.manage.service.StaffRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-03 13:09
 * @ClassName StaffController
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffRepositoryService staffRepositoryService;




}
