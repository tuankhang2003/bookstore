package com.bookStore.bookstore.repository;

import com.bookStore.bookstore.book.Book;
import com.bookStore.bookstore.book.MyBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyBook, Integer> {

}
