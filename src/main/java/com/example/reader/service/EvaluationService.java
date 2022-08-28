package com.example.reader.service;

import com.example.reader.entity.Evaluation;

import java.util.List;
import java.util.Map;

public interface EvaluationService {
    List<Map> selectByBookId(Long bookId);

    Evaluation evaluate(Long memberId, Long bookId, Integer score, String content);

    Evaluation enjoy(Long evaluationId);
}
