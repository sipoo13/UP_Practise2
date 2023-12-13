package com.example.practise2.controller;

import com.example.practise2.dao.UserDao;
import com.example.practise2.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserDao _userDao;

    @Autowired
    public UserController(UserDao userDao) {_userDao = userDao;}

    @GetMapping()
    public String index(Model model){
        model.addAttribute("users", _userDao.index());
        return "user/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("user", _userDao.show(id));
        return "user/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") UserModel userModel){
        // model.addAttribute("person", new PersonModel());
        return "user/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") UserModel userModel){
        _userDao.save(userModel);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user",_userDao.show(id));
        return "user/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") UserModel userModel, @PathVariable("id") int id){
        _userDao.update(userModel,id);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        _userDao.delete(id);
        return "redirect:/users";
    }
}
