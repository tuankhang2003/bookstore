package com.bookStore.bookstore.controller;

import com.bookStore.bookstore.book.Book;
import com.bookStore.bookstore.book.MyBook;
import com.bookStore.bookstore.service.BookService;
import com.bookStore.bookstore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class WebController {
    @Autowired
    private BookService bookService;
    @Autowired
    private MyBookService myBookService;

    public WebController(BookService bookService, MyBookService myBookService) {
        this.bookService = bookService;
        this.myBookService=myBookService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/register_book")
    public String registerBook() {
        return "bookRegister";
    }
    @GetMapping("/available_book")
    public ModelAndView availableBook() {
        return new ModelAndView("bookAvailable", "Book", bookService.getAllBooks());
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book) {
        Optional<Book>bookOptional=bookService.getBookById(book.getId());

        if (bookOptional.isPresent()) {
            bookService.updateBook(book);
        }
        else{
            bookService.addBook(book);
        }
        Optional<MyBook>myBookOptional=myBookService.getMyBookById(book.getId());
        if (myBookOptional.isPresent()) {
            myBookService.updateMyBook(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice());
        }
        return "redirect:/available_book";
    }
}
