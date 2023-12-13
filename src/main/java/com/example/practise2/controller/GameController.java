package com.example.practise2.controller;

import com.example.practise2.dao.BookDao;
import com.example.practise2.dao.GameDao;
import com.example.practise2.model.BookModel;
import com.example.practise2.model.GameModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("games")
public class GameController {
    private GameDao _gameDao;

    @Autowired
    public GameController(GameDao gameDao) {_gameDao = gameDao; }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("games", _gameDao.index());
        return "game/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("game", _gameDao.show(id));
        return "game/show";
    }

    @GetMapping("/new")
    public String newGame(@ModelAttribute("game") GameModel gameModel){
        return "game/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("game") GameModel gameModel){
        _gameDao.save(gameModel);
        return "redirect:/games";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("game",_gameDao.show(id));
        return "game/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("game") GameModel gameModel, @PathVariable("id") int id){
        _gameDao.update(gameModel,id);
        return "redirect:/games";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        _gameDao.delete(id);
        return "redirect:/games";
    }
}
