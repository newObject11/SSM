package com.zlb.service.imp;

import com.zlb.mapper.BookMapper;
import com.zlb.pojo.Book;
import com.zlb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookMapper bookMapper;

    public boolean save(Book book) {
        return bookMapper.save(book) > 0;
    }

    public boolean update(Book book) {
        return bookMapper.update(book) > 0;
    }

    public boolean delete(Integer id) {
        return bookMapper.delete(id) > 0;
    }

    public Book getById(Integer id) {
        return bookMapper.getById(id);
    }

    public List<Book> getAll() {
        return bookMapper.getAll();
    }
}
