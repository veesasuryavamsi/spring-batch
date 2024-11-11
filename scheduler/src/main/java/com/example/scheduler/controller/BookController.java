package com.example.scheduler.controller;

import com.example.scheduler.config.writer.BookWriter;
import com.example.scheduler.entity.BookEntity;
import com.example.scheduler.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<BookEntity> getAll() {
        log.info("Handling find all");
        log.info("Hi there");
        return bookRepository.findAll();
    }
}
