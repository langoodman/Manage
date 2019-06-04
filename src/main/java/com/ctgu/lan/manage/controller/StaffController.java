package com.ctgu.lan.manage.controller;

import com.ctgu.lan.manage.model.Staff;
import com.ctgu.lan.manage.service.StaffRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    /**
     * 获得员工总数
     * @return
     */
    @RequestMapping("/getStaffDataCount")
    @ResponseBody
    public String getStaffDataCount(){
        long count = staffRepositoryService.countStaff();
        return String.valueOf(count);
    }


    /**
     * 员工分页查询
     * @param startPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/getStaffData")
    @ResponseBody
    public List<Staff> getStaffData(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                   @RequestParam(value = "PageSize", required = false, defaultValue = "10") Integer pageSize){
        Page<Staff> staff = staffRepositoryService.findAll(PageRequest.of(startPage - 1, pageSize));
        List<Staff> staffList = staff.getContent();
        return staffList;
    }


    /**
     * 看进行的是什么操作
     * @param staff
     * @param attributes
     * @return
     */
    @RequestMapping("/operationStaff")
    public String operationStaff(Staff staff, RedirectAttributes attributes){
        if(staff.getId() == null){
            attributes.addFlashAttribute("adminStaff", staff);
            return "redirect:/staff/addStaffInfo";
        }else {
            attributes.addFlashAttribute("adminStaff", staff);
            return "redirect:/staff/updateStaffInfo";
        }
    }

    /**
     * 添加一个员工
     * @param staff
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/addStaffInfo")
    @ResponseBody
    public String addOneStaff(@ModelAttribute("adminStaff")Staff staff , Model model , HttpSession session ){
        if( staffRepositoryService.findByPhoneNumber(staff.getPhoneNumber()) != null ){
            model.addAttribute("manageStaffMsg", "该员工已存在!");
            return "0";
        }
        else {
            staffRepositoryService.addStaffInfo(staff);
            model.addAttribute("manageStaffMsg", "增加成功!");
            return "1";
        }
    }

    /**
     * 修改员工的信息
     * @param model
     * @param session
     * @param staff
     * @return
     */
    @RequestMapping("/updateStaffInfo")
    @ResponseBody
    public String updateOneStaff( Model model , HttpSession session ,@ModelAttribute("adminStaff") Staff staff ){
        if( staffRepositoryService.findByPhoneNumber(staff.getPhoneNumber()) == null ){
            model.addAttribute("manageStaffMsg", "该员工不存在!");
            return "0";
        }
        else {
            staffRepositoryService.updateStaffInfo(staff);
            model.addAttribute("manageStaffMsg", "修改成功!");
            return "1";
        }
    }

    /**
     * 删除员工的信息
     * @param model
     * @param session
     * @param id
     * @return
     */
    @RequestMapping("/delStaff")
    @ResponseBody
    public String deleOneStaff( Model model , HttpSession session,
                                  @RequestParam("id") String id ){
        List<String> stringIdList = Arrays.asList(id.split(","));
        List<Integer> idList = new ArrayList<Integer>();
        for( String str : stringIdList ){
            idList.add(Integer.parseInt(str));
        }
        for( Integer idNum : idList ){
            if( staffRepositoryService.findOneById(idNum) == null ){
                model.addAttribute("manageStaffMsg", "该员工不存在!");
                return "0";
            }
            else{
                staffRepositoryService.deleSatffById(idNum);
            }
        }
        model.addAttribute("manageStaffMsg", "删除成功!");
        return "1";
    }

    /**
     * 通过电话号码查询
     * @param staff
     * @param session
     * @return
     */
    @RequestMapping("/findStaffByPhoneNumber")
    @ResponseBody
    public Staff findStaffByPhoneNumber(@RequestBody(required = false) Staff staff,
                                      HttpSession session){
        Staff findStaff = staffRepositoryService.findByPhoneNumber(staff.getPhoneNumber());
        if( findStaff == null ){
            staff.setName("errorFind");
            return staff;
        }
        return findStaff;
    }

}
