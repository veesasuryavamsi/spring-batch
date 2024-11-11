package com.example.scheduler.config.reader;

import com.example.scheduler.entity.BookEntity;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ItemReader {

    @Bean
    @StepScope
    public FlatFileItemReader<BookEntity> reader(){
        return new FlatFileItemReaderBuilder<BookEntity>()
                .name("bookReader")
                .resource(new ClassPathResource("book_data.csv"))
                .delimited()
                .names(new String[]{"title", "author", "yearOfPublishing"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(BookEntity.class);
                }})
        .build();

    }
}
