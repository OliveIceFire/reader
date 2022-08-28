package com.example.reader.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.reader.entity.Book;

import java.util.Map;

public interface BookMapper extends BaseMapper<Book> {
    void updateScore();

    IPage<Map> selectBookMap(IPage page);
}
