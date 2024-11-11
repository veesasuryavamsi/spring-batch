package com.example.scheduler.config.writer;

import com.example.scheduler.entity.BookEntity;
import com.example.scheduler.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class BookWriter implements ItemWriter<BookEntity> {
    private static final Logger log = LoggerFactory.getLogger(BookWriter.class);

    public BookWriter(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    private BookRepository bookRepository;

//    public BookRepository getBookRepository() {
//        return bookRepository;
//    }
//
//    public void setBookRepository(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

    @Override
    public void write(Chunk<? extends BookEntity> chunk) throws Exception {
        log.info("Writing: {}", chunk.getItems().size());
//        if(bookRepository != null) {/
        bookRepository.saveAll(chunk.getItems());}
//    }
}


;