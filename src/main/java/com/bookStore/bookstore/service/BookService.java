package com.bookStore.bookstore.service;

import com.bookStore.bookstore.book.Book;
import com.bookStore.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public Optional<Book> getBookById(int id) {
       return bookRepository.findById(id);
    }
    public void addBook(Book book) {
        Optional<Book> bookOptional=bookRepository.findById(book.getId());
        if (bookOptional.isPresent()){
            return;
        }
        bookRepository.save(book);
    }
    public void deleteBookById(int id) {
        if (!bookRepository.existsById(id)){
            throw new IllegalStateException("Book not found");
        }
        bookRepository.deleteById(id);
    }
    @Transactional
    public void updateBook(Book book) {
        Book oldBook=bookRepository.findById(book.getId()).orElseThrow();
        oldBook.setAuthor(book.getAuthor());
        oldBook.setTitle(book.getTitle());
        oldBook.setPrice(book.getPrice());
        oldBook.setId(book.getId());
        bookRepository.save(oldBook);
    }
    public void saveBook(Book book){
        bookRepository.save(book);
    }

}
