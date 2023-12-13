package com.example.practise2.dao;

import com.example.practise2.Dao;
import com.example.practise2.model.BookModel;
import com.example.practise2.model.GameModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDao implements Dao<BookModel> {
    private static int BOOK_COUNT;
    private List<BookModel> books = new ArrayList<>();
    @Override
    public BookModel show(int id) {
        return books.stream().filter(bookModel -> bookModel.getId() == id).findAny().orElse(null);
    }

    @Override
    public List<BookModel> index() {
        return books;
    }

    @Override
    public void save(BookModel bookModel) {
        bookModel.setId(++BOOK_COUNT);
        books.add(bookModel);
    }

    @Override
    public void update(BookModel bookModel, int id) {
        BookModel updatedBook = show(id);
        updatedBook.setAuthor(bookModel.getAuthor());
        updatedBook.setIsbn(bookModel.getIsbn());
        updatedBook.setTitle(bookModel.getTitle());
    }

    @Override
    public void delete(int id) {
        books.removeIf(bookModel -> bookModel.getId() == id);
    }
}
