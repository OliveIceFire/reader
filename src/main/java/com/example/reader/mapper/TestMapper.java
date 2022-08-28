package com.example.reader.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.reader.entity.TestTable;

//CREATE DATABASE `reader` CHARACTER SET utf8 COLLATE utf8_general_ci;
public interface TestMapper extends BaseMapper<TestTable> {
    public void insertSample();
}
