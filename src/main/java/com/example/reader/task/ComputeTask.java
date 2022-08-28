package com.example.reader.task;

import com.example.reader.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component//自动被实例化
public class ComputeTask {
    Logger logger = LoggerFactory.getLogger(ComputeTask.class);

    @Autowired
    BookService bookService;

    @Scheduled(cron = "0 * * * * ? ")
    public void updateScore() {
        logger.info("更新了图书评分");
        bookService.updateScore();

    }
}
