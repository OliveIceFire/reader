package com.example.reader.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.reader.entity.Book;
import org.springframework.transaction.annotation.Transactional;

public interface BookService {
    IPage<Book> selectPage(Long categoryId, String order, Integer page, Integer rows);

    Book selectById(Long bookId);

    @Transactional(rollbackFor = Exception.class)
    void updateScore();
}
