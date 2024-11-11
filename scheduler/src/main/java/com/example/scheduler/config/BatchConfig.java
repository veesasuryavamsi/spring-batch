package com.example.scheduler.config;

import com.example.scheduler.config.processor.Processor;
import com.example.scheduler.config.reader.ItemReader;
import com.example.scheduler.config.writer.Writer;
import com.example.scheduler.entity.BookEntity;
import com.example.scheduler.repository.BookRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    @Autowired
    private BookRepository bookRepository;

    public BatchConfig(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Bean
    public Job bookReaderJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) throws Exception {
        return new JobBuilder("bookReaderJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(csvFile(jobRepository, transactionManager))
                .build();
    }

    @Bean
    public Step csvFile(JobRepository jobRepository, PlatformTransactionManager transactionManager) throws Exception {
        ItemReader itemReader = new ItemReader();
        Processor itemProcessor = new Processor();

        Writer itemWriter = new Writer(bookRepository);
        return new StepBuilder("bookReaderStep", jobRepository).<BookEntity, BookEntity>chunk(10, transactionManager)
                .reader(itemReader.reader())
                .processor(itemProcessor.processor2())
                .writer(itemWriter.writer1())
                .build();
    }
}
