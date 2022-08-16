package com.example.reader.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.reader.entity.Evaluation;

import java.util.List;
import java.util.Map;

public interface EvaluationMapper extends BaseMapper<Evaluation> {
    List<Map> selectByBookId(Long bookId);
}
