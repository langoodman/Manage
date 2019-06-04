package com.ctgu.lan.manage.controller;

import com.ctgu.lan.manage.model.Pharmacy;
import com.ctgu.lan.manage.service.PharmacyRepositoryService;
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
 * @create 2019-06-03 21:06
 * @ClassName PharmacyController
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/pharmacy")
public class PharmacyController {
    @Autowired
    private PharmacyRepositoryService pharmacyRepositoryService;

    /**
     * 获得药店总数
     * @return
     */
    @RequestMapping("/getPharmacyDataCount")
    @ResponseBody
    public String getPharmacyDataCount(){
        long count = pharmacyRepositoryService.countPharmacy();
        return String.valueOf(count);
    }


    /**
     * 药店分页查询
     * @param startPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/getPharmacyData")
    @ResponseBody
    public List<Pharmacy> getPharmacyData(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                          @RequestParam(value = "PageSize", required = false, defaultValue = "10") Integer pageSize){
        Page<Pharmacy> pharmacies = pharmacyRepositoryService.findAll(PageRequest.of(startPage - 1, pageSize));
        List<Pharmacy> pharmacyList = pharmacies.getContent();
        return pharmacyList;
    }


    /**
     * 看进行的是什么操作
     * @param pharmacy
     * @param attributes
     * @return
     */
    @RequestMapping("/operationPharmacy")
    public String operationPharmacy(Pharmacy pharmacy, RedirectAttributes attributes){
        if(pharmacy.getId() == null){
            attributes.addFlashAttribute("adminPharmacy", pharmacy);
            return "redirect:/pharmacy/addPharmacyInfo";
        }else {
            attributes.addFlashAttribute("adminPharmacy", pharmacy);
            return "redirect:/pharmacy/updatePharmacyInfo";
        }
    }

    /**
     * 添加一个药店
     * @param pharmacy
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/addPharmacyInfo")
    @ResponseBody
    public String addOnePharmacy(@ModelAttribute("adminPharmacy")Pharmacy pharmacy , Model model , HttpSession session ){
        if( pharmacyRepositoryService.findOneById(pharmacy.getId()) != null ){
            model.addAttribute("managePharmacyMsg", "该药店已存在!");
            return "0";
        }
        else {
            pharmacyRepositoryService.addPharmacyInfo(pharmacy);
            model.addAttribute("managePharmacyMsg", "增加成功!");
            return "1";
        }
    }

    /**
     * 修改药店的信息
     * @param model
     * @param session
     * @param pharmacy
     * @return
     */
    @RequestMapping("/updatePharmacyInfo")
    @ResponseBody
    public String updateOnePharmacy( Model model , HttpSession session ,@ModelAttribute("adminPharmacy") Pharmacy pharmacy ){
        if( pharmacyRepositoryService.findOneById(pharmacy.getId()) == null ){
            model.addAttribute("managePharmacyMsg", "该药店不存在!");
            return "0";
        }
        else {
            pharmacyRepositoryService.updatePharmacyInfo(pharmacy);
            model.addAttribute("managePharmacyMsg", "修改成功!");
            return "1";
        }
    }

    /**
     * 删除药店的信息
     * @param model
     * @param session
     * @param id
     * @return
     */
    @RequestMapping("/delPharmacy")
    @ResponseBody
    public String deleOnePharmacy( Model model , HttpSession session,
                                   @RequestParam("id") String id ){
        List<String> stringIdList = Arrays.asList(id.split(","));
        List<Integer> idList = new ArrayList<Integer>();
        for( String str : stringIdList ){
            idList.add(Integer.parseInt(str));
        }
        for( Integer idNum : idList ){
            if( pharmacyRepositoryService.findOneById(idNum) == null ){
                model.addAttribute("managePharmacyMsg", "该药店不存在!");
                return "0";
            }
            else{
                pharmacyRepositoryService.delePharmacyById(idNum);

            }
        }
        model.addAttribute("managePharmacyMsg", "删除成功!");
        return "1";
    }
//    @RequestMapping("/delPharmacy")
//    @ResponseBody
//    public String deleOnePharmacy( Model model , HttpSession session,
//                                @RequestParam("id") Integer id ){
//        if( pharmacyRepositoryService.findOneById(id) == null ){
//            model.addAttribute("managePharmacyMsg", "该药店不存在!");
//            return "0";
//        }
//        else {
//            pharmacyRepositoryService.delePharmacyById(id);
//            model.addAttribute("managePharmacyMsg", "删除成功!");
//            return "1";
//        }
//    }

    /**
     * 通过名字查询
     * @param pharmacy
     * @param session
     * @return
     */
    @RequestMapping("/findPharmacyByName")
    @ResponseBody
    public Pharmacy findPharmacyByName(@RequestBody(required = false) Pharmacy pharmacy,
                                        HttpSession session){
        Pharmacy findPharmacy = pharmacyRepositoryService.findByName(pharmacy.getName());
        if( findPharmacy == null ){
            pharmacy.setName("errorFind");
            return pharmacy;
        }
        return findPharmacy;
    }
}
