package com.ctgu.lan.manage.controller;

import com.ctgu.lan.manage.model.Orders;
import com.ctgu.lan.manage.service.OrdersRepositoryService;
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
 * @create 2019-06-04 15:42
 * @ClassName OrdersController
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersRepositoryService ordersRepositoryService;

    /**
     * 获得订单总数
     * @return
     */
    @RequestMapping("/getOrdersDataCount")
    @ResponseBody
    public String getOrdersDataCount(){
        long count = ordersRepositoryService.countOrders();
        return String.valueOf(count);
    }


    /**
     * 订单分页查询
     * @param startPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/getOrdersData")
    @ResponseBody
    public List<Orders> getOrdersData(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                        @RequestParam(value = "PageSize", required = false, defaultValue = "10") Integer pageSize){
        Page<Orders> orders = ordersRepositoryService.findAll(PageRequest.of(startPage - 1, pageSize));
        List<Orders> ordersList = orders.getContent();
        return ordersList;
    }


    /**
     * 看进行的是什么操作
     * @param orders
     * @param attributes
     * @return
     */
    @RequestMapping("/operationOrders")
    public String operationOrders(Orders orders, RedirectAttributes attributes){
        if(orders.getId() == null){
            attributes.addFlashAttribute("adminOrders", orders);
            return "redirect:/orders/addOrdersInfo";
        }else {
            attributes.addFlashAttribute("adminOrders", orders);
            return "redirect:/orders/updateOrdersInfo";
        }
    }

    /**
     * 添加一个订单
     * @param orders
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/addOrdersInfo")
    @ResponseBody
    public String addOneOrders(@ModelAttribute("adminOrders")Orders orders , Model model , HttpSession session ){
        if( ordersRepositoryService.findOneById(orders.getId()) != null ){
            model.addAttribute("manageOrdersMsg", "该订单已存在!");
            return "0";
        }
        else {
            ordersRepositoryService.addOrdersInfo(orders);
            model.addAttribute("manageOrdersMsg", "增加成功!");
            return "1";
        }
    }

    /**
     * 修改订单的信息
     * @param model
     * @param session
     * @param orders
     * @return
     */
    @RequestMapping("/updateOrdersInfo")
    @ResponseBody
    public String updateOneOrders( Model model , HttpSession session ,@ModelAttribute("adminOrders") Orders orders ){
        if( ordersRepositoryService.findOneById(orders.getId()) == null ){
            model.addAttribute("manageOrdersMsg", "该订单不存在!");
            return "0";
        }
        else {
            ordersRepositoryService.updateOrdersInfo(orders);
            model.addAttribute("manageOrdersMsg", "修改成功!");
            return "1";
        }
    }

    /**
     * 删除订单的信息
     * @param model
     * @param session
     * @param id
     * @return
     */
    @RequestMapping("/delOrders")
    @ResponseBody
    public String deleOneOrders( Model model , HttpSession session,
                                   @RequestParam("id") String id ){
        List<String> stringIdList = Arrays.asList(id.split(","));
        List<Integer> idList = new ArrayList<Integer>();
        for( String str : stringIdList ){
            idList.add(Integer.parseInt(str));
        }
        for( Integer idNum : idList ){
            if( ordersRepositoryService.findOneById(idNum) == null ){
                model.addAttribute("manageOrdersMsg", "该订单不存在!");
                return "0";
            }
            else{
                ordersRepositoryService.deleOrdersById(idNum);

            }
        }
        model.addAttribute("manageOrdersMsg", "删除成功!");
        return "1";
    }

    /**
     * 通过药店名字查询
     * @param orders
     * @param session
     * @return
     */
    @RequestMapping("/findOrdersByPharmacyName")
    @ResponseBody
    public Orders findOrdersByPharmacyName(@RequestBody(required = false) Orders orders,
                                       HttpSession session){
        Orders findOrders = ordersRepositoryService.findOneByPharmacyName(orders.getPharmacyName());
        if( findOrders == null ){
            orders.setPharmacyName("errorFind");
            return orders;
        }
        return findOrders;
    }
}
