package com.ctgu.lan.manage.controller;

import com.ctgu.lan.manage.model.Medicine;
import com.ctgu.lan.manage.service.MedicineRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-06-04 8:16
 * @ClassName MedicineController
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/medicine")
public class MedicineController {
    @Autowired
    private MedicineRepositoryService medicineRepositoryService;

    /**
     * 获得药品总数
     * @return
     */
    @RequestMapping("/getMedicineDataCount")
    @ResponseBody
    public String getMedicineDataCount(){
        long count = medicineRepositoryService.countMedicine();
        return String.valueOf(count);
    }


    /**
     * 药品分页查询
     * @param startPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/getMedicineData")
    @ResponseBody
    public List<Medicine> getMedicineData(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                          @RequestParam(value = "PageSize", required = false, defaultValue = "10") Integer pageSize){
        Page<Medicine> medicines = medicineRepositoryService.findAll(PageRequest.of(startPage - 1, pageSize));
        List<Medicine> medicineList = medicines.getContent();
        return medicineList;
    }


    /**
     * 看进行的是什么操作
     * @param medicine
     * @param attributes
     * @return
     */
    @RequestMapping("/operationMedicine")
    public String operationMedicine(Medicine medicine, RedirectAttributes attributes){
        if(medicine.getId() == null){
            attributes.addFlashAttribute("adminMedicine", medicine);
            return "redirect:/medicine/addMedicineInfo";
        }else {
            attributes.addFlashAttribute("adminMedicine", medicine);
            return "redirect:/medicine/updateMedicineInfo";
        }
    }

    /**
     * 添加一个药品
     * @param medicine
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/addMedicineInfo")
    @ResponseBody
    public String addMedicineInfo(@ModelAttribute("adminMedicine")Medicine medicine , Model model , HttpSession session ){
        if( medicineRepositoryService.findOneById(medicine.getId()) != null ){
            model.addAttribute("manageMedicineMsg", "该药品已存在!");
            return "0";
        }
        else {
            medicineRepositoryService.addMedicineInfo(medicine);
            model.addAttribute("manageMedicineMsg", "增加成功!");
            return "1";
        }
    }

    /**
     * 修改药品的信息
     * @param model
     * @param session
     * @param medicine
     * @return
     */
    @RequestMapping("/updateMedicineInfo")
    @ResponseBody
    public String updateMedicineInfo( Model model , HttpSession session ,@ModelAttribute("adminMedicine") Medicine medicine ){
        if( medicineRepositoryService.findOneById(medicine.getId()) == null ){
            model.addAttribute("manageMedicineMsg", "该药品不存在!");
            return "0";
        }
        else {
            medicineRepositoryService.updateMedicineInfo(medicine);
            model.addAttribute("manageMedicineMsg", "修改成功!");
            return "1";
        }
    }

    /**
     * 删除药药品的信息
     * @param model
     * @param session
     * @param id
     * @return
     */
    @RequestMapping("/delMedicine")
    @ResponseBody
    public String delMedicine( Model model , HttpSession session,
                                   @RequestParam("id") Integer id ){
        if( medicineRepositoryService.findOneById(id) == null ){
            model.addAttribute("manageMedicineMsg", "该药品不存在!");
            return "0";
        }
        else {
            medicineRepositoryService.deleMedicineById(id);
            model.addAttribute("manageMedicineMsg", "删除成功!");
            return "1";
        }
    }

    /**
     * 通过名字查询
     * @param medicine
     * @param session
     * @return
     */
    @RequestMapping("/findMedicineByName")
    @ResponseBody
    public Medicine findMedicineByName(@RequestBody(required = false) Medicine medicine,
                                       HttpSession session){
        Medicine findMedinice = medicineRepositoryService.findByName(medicine.getName());
        if( findMedinice == null ){
            medicine.setName("errorFind");
            return medicine;
        }
        return findMedinice;
    }


}
