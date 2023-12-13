package com.example.practise2.controller;

import com.example.practise2.dao.GameDao;
import com.example.practise2.dao.ProductDao;
import com.example.practise2.model.GameModel;
import com.example.practise2.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductDao _productDao;

    @Autowired
    public ProductController(ProductDao productDao) {_productDao = productDao; }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("products", _productDao.index());
        return "product/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("product", _productDao.show(id));
        return "product/show";
    }

    @GetMapping("/new")
    public String newProduct(@ModelAttribute("product") ProductModel productModel){
        return "product/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") ProductModel productModel){
        _productDao.save(productModel);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("product",_productDao.show(id));
        return "product/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("product") ProductModel productModel, @PathVariable("id") int id){
        _productDao.update(productModel,id);
        return "redirect:/products";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        _productDao.delete(id);
        return "redirect:/products";
    }
}
