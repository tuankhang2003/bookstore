package com.bookStore.bookstore.repository;

import com.bookStore.bookstore.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
