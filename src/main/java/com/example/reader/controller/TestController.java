package com.example.reader.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @PostMapping("/t/test1")
    public Map test1(String context) {
        Map result = new HashMap();
        result.put("test", "测试:" + context);
        return result;
    }
}
