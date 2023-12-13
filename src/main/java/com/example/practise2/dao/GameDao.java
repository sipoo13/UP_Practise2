package com.example.practise2.dao;

import com.example.practise2.Dao;
import com.example.practise2.model.GameModel;
import com.example.practise2.model.OrderModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameDao implements Dao<GameModel> {
    private static int GAME_COUNT;
    private List<GameModel> games = new ArrayList<>();
    @Override
    public GameModel show(int id) {
        return games.stream().filter(gameModel -> gameModel.getId() == id).findAny().orElse(null);
    }

    @Override
    public List<GameModel> index() {
        return games;
    }

    @Override
    public void save(GameModel gameModel) {
        gameModel.setId(++GAME_COUNT);
        games.add(gameModel);
    }

    @Override
    public void update(GameModel gameModel, int id) {
        GameModel updatedGameModel = show(id);
        updatedGameModel.setName(gameModel.getName());
        updatedGameModel.setYear(gameModel.getYear());
        updatedGameModel.setDescription(gameModel.getDescription());
    }

    @Override
    public void delete(int id) {
        games.removeIf(gameModel -> gameModel.getId() == id);
    }
}
