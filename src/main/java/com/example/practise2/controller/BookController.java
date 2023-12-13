package com.example.practise2.controller;

import com.example.practise2.dao.BookDao;
import com.example.practise2.dao.UserDao;
import com.example.practise2.model.BookModel;
import com.example.practise2.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("books")
public class BookController {
    private BookDao _bookDao;

    @Autowired
    public BookController(BookDao bookDao) {_bookDao = bookDao; }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("books", _bookDao.index());
        return "book/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("book", _bookDao.show(id));
        return "book/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("book") BookModel bookModel){
        return "book/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") BookModel bookModel){
        _bookDao.save(bookModel);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("book",_bookDao.show(id));
        return "book/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") BookModel bookModel, @PathVariable("id") int id){
        _bookDao.update(bookModel,id);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        _bookDao.delete(id);
        return "redirect:/books";
    }
}
