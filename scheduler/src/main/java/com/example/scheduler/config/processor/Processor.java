package com.example.scheduler.config.processor;

import com.example.scheduler.entity.BookEntity;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
public class Processor {

    @Bean
    @StepScope
    public ItemProcessor<BookEntity, BookEntity> processor2(){
        CompositeItemProcessor<BookEntity, BookEntity> processor1 = new CompositeItemProcessor<>();
        processor1.setDelegates(List.of(new BookProcessor()));
        return processor1;

    }
}
