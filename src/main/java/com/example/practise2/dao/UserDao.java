package com.example.practise2.dao;

import com.example.practise2.Dao;
import com.example.practise2.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDao implements Dao<UserModel> {
    private static int USER_COUNT;
    private List<UserModel> users = new ArrayList<>();

    @Override
    public UserModel show(int id) {
        return users.stream().filter(userModel -> userModel.get_id() == id).findAny().orElse(null);
    }

    @Override
    public List<UserModel> index() {
        return users;
    }

    @Override
    public void save(UserModel userModel) {
        userModel.set_id(++USER_COUNT);
        users.add(userModel);
    }

    @Override
    public void update(UserModel userModel, int id) {
        UserModel updatedUser = show(id);
        updatedUser.setName(userModel.getName());
        updatedUser.setLogin(userModel.getLogin());
        updatedUser.setPassword(userModel.getPassword());
    }

    @Override
    public void delete(int id) {
        users.removeIf(p -> p.get_id() == id);
    }
}
