package com.example.scheduler.config.writer;

import com.example.scheduler.entity.BookEntity;
import com.example.scheduler.repository.BookRepository;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Writer {

    @Autowired
    private BookRepository bookRepository;

    public Writer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @StepScope
    @Bean
    public ItemWriter<BookEntity> writer1() {
        return new BookWriter(bookRepository);
    }
}
