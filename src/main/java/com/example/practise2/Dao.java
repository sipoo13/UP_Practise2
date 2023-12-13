package com.example.practise2;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    T show(int id);
    List<T> index();
    void save(T t);
    void update(T t, int id);
    void delete(int id);
}