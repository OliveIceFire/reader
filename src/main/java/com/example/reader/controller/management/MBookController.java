package com.example.reader.controller.management;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.reader.service.BookService;
import com.example.reader.utils.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/management/book")
public class MBookController {

    @Resource
    private BookService bookService;

    @GetMapping("/list")
    public ResponseUtils list(Integer page, Integer rows) {
        if (page == null) {
            page = 1;
        }
        if (rows == null) {
            page = 10;
        }
        ResponseUtils responseUtils;
        try {
            IPage p = bookService.selectBookMap(page, rows);
            responseUtils = new ResponseUtils().put("list",p.getRecords()).put("count", p.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            responseUtils = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return responseUtils;
    }
}
