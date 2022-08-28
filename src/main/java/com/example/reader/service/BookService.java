package com.example.reader.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.reader.entity.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

public interface BookService {
    IPage<Book> selectPage(Long categoryId, String order, Integer page, Integer rows);

    Book selectById(Long bookId);

    @Transactional(rollbackFor = Exception.class)
    void updateScore();

    IPage<Map> selectBookMap(Integer page, Integer rows);
}
