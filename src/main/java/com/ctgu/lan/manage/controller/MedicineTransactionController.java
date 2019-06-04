package com.ctgu.lan.manage.controller;

import com.ctgu.lan.manage.model.MedicineTransaction;
import com.ctgu.lan.manage.service.MedicineTransactionRepositoryService;
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
 * @create 2019-06-04 19:48
 * @ClassName MedicineTransactionController
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/medicineTransaction")
public class MedicineTransactionController {
    @Autowired
    private MedicineTransactionRepositoryService medicineTransactionRepositoryService;

    @RequestMapping("/getMedicineTransactionDataCount")
    @ResponseBody
    public String getMedicineTransactionDataCount(){
        long count = medicineTransactionRepositoryService.countMedicineTransaction();
        return String.valueOf(count);
    }


    /**
     * 交易分页查询
     * @param startPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/getMedicineTransactionData")
    @ResponseBody
    public List<MedicineTransaction> getMedicineTransactionData(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                      @RequestParam(value = "PageSize", required = false, defaultValue = "10") Integer pageSize){
        Page<MedicineTransaction> medicineTransactions = medicineTransactionRepositoryService.findAll(PageRequest.of(startPage - 1, pageSize));
        List<MedicineTransaction> medicineTransactionList = medicineTransactions.getContent();
        return medicineTransactionList;
    }


    /**
     * 看进行的是什么操作
     * @param medicineTransaction
     * @param attributes
     * @return
     */
    @RequestMapping("/operationMedicineTransaction")
    public String operationMedicineTransaction(MedicineTransaction medicineTransaction, RedirectAttributes attributes){
        if(medicineTransaction.getId() == null){
            attributes.addFlashAttribute("adminMedicineTransaction", medicineTransaction);
            return "redirect:/medicineTransaction/addMedicineTransactionInfo";
        }else {
            attributes.addFlashAttribute("adminMedicineTransaction", medicineTransaction);
            return "redirect:/medicineTransaction/updateMedicineTransactionInfo";
        }
    }

    /**
     * 添加一个交易
     * @param medicineTransaction
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/addMedicineTransactionInfo")
    @ResponseBody
    public String addMedicineTransactionInfo(@ModelAttribute("adminMedicineTransaction")MedicineTransaction medicineTransaction ,
                               Model model , HttpSession session ){
        if( medicineTransactionRepositoryService.findOneById(medicineTransaction.getId()) != null ){
            model.addAttribute("manageMedicineTransaction", "该记录已存在!");
            return "0";
        }
        else {
            medicineTransactionRepositoryService.addMedicineTransactionInfo(medicineTransaction);
            model.addAttribute("manageMedicineTransaction", "增加成功!");
            return "1";
        }
    }

    /**
     * 修改记录的信息
     * @param model
     * @param session
     * @param medicineTransaction
     * @return
     */
    @RequestMapping("/updateMedicineTransactionInfo")
    @ResponseBody
    public String updateMedicineTransactionInfo( Model model , HttpSession session ,
                                   @ModelAttribute("adminMedicineTransaction") MedicineTransaction medicineTransaction ){
        if( medicineTransactionRepositoryService.findOneById(medicineTransaction.getId()) == null ){
            model.addAttribute("manageMedicineTransaction", "该记录不存在!");
            return "0";
        }
        else {
            medicineTransactionRepositoryService.updateMedicineTransactionInfo(medicineTransaction);
            model.addAttribute("manageMedicineTransaction", "修改成功!");
            return "1";
        }
    }

    /**
     * 删除记录的信息
     * @param model
     * @param session
     * @param id
     * @return
     */
    @RequestMapping("/delMedicineTransaction")
    @ResponseBody
    public String delMedicineTransaction( Model model , HttpSession session,
                                 @RequestParam("id") String id ){
        List<String> stringIdList = Arrays.asList(id.split(","));
        List<Integer> idList = new ArrayList<Integer>();
        for( String str : stringIdList ){
            idList.add(Integer.parseInt(str));
        }
        for( Integer idNum : idList ){
            if( medicineTransactionRepositoryService.findOneById(idNum) == null ){
                model.addAttribute("manageMedicineTransaction", "该记录不存在!");
                return "0";
            }
            else{
                medicineTransactionRepositoryService.deleOrdersById(idNum);
            }
        }
        model.addAttribute("manageMedicineTransaction", "删除成功!");
        return "1";
    }

    /**
     * 通过药品名字查询
     * @param medicineTransaction
     * @param session
     * @return
     */
    @RequestMapping("/findMedicineTransactionByMedicineName")
    @ResponseBody
    public MedicineTransaction findMedicineTransactionByMedicineName(@RequestBody(required = false) MedicineTransaction medicineTransaction,
                                           HttpSession session){
        MedicineTransaction findMedicineTransaction =
                medicineTransactionRepositoryService.findOneByMedicineName(medicineTransaction.getMedicineName());
        if( findMedicineTransaction == null ){
            medicineTransaction.setMedicineName("errorFind");
            return medicineTransaction;
        }
        return findMedicineTransaction;
    }

}
