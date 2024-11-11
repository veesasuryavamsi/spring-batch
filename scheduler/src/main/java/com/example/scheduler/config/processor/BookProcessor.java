package com.example.scheduler.config.processor;

import com.example.scheduler.config.BatchConfig;
import com.example.scheduler.config.reader.ItemReader;
import com.example.scheduler.entity.BookEntity;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
public class BookProcessor implements ItemProcessor<BookEntity, BookEntity> {

    private static final Logger log = LoggerFactory.getLogger(BookProcessor.class);



    @Override
    public BookEntity process(BookEntity item) throws Exception {
        log.info("Processing title for {}", item);
        item.setTitle(item.getTitle().toUpperCase());
        item.setAuthor("By" + item.getAuthor());
        return item;
    }
}
