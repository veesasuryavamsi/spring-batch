package com.example.scheduler.repository;

import com.example.scheduler.entity.BookEntity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface BookRepository  extends JpaRepository<BookEntity, Long> {
}
