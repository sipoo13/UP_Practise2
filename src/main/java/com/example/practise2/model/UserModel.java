package com.example.practise2.model;

public class UserModel {
    private int _id;
    private String name;
    private String login;
    private String password;

    public UserModel(){};
    public UserModel(int _id, String name, String login, String password) {
        this._id = _id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
