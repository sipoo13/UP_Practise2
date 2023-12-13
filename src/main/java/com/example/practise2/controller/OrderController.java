package com.example.practise2.controller;

import com.example.practise2.dao.GameDao;
import com.example.practise2.dao.OrderDao;
import com.example.practise2.model.GameModel;
import com.example.practise2.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private OrderDao _orderDao;

    @Autowired
    public OrderController(OrderDao orderDao) {_orderDao = orderDao; }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("orders", _orderDao.index());
        return "order/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("order", _orderDao.show(id));
        return "order/show";
    }

    @GetMapping("/new")
    public String newOrder(@ModelAttribute("order") OrderModel orderModel){
        return "order/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("order") OrderModel orderModel){
        _orderDao.save(orderModel);
        return "redirect:/orders";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("order",_orderDao.show(id));
        return "order/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("order") OrderModel orderModel, @PathVariable("id") int id){
        _orderDao.update(orderModel,id);
        return "redirect:/orders";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        _orderDao.delete(id);
        return "redirect:/orders";
    }
}
