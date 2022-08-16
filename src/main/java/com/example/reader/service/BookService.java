package com.example.reader.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.reader.entity.Book;

public interface BookService {
    IPage<Book> selectPage(Long categoryId, String order, Integer page, Integer rows);

    Book selectById(Long bookId);
}
