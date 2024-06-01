package com.bookStore.bookstore.controller;

import com.bookStore.bookstore.book.Book;
import com.bookStore.bookstore.book.MyBook;
import com.bookStore.bookstore.service.BookService;
import com.bookStore.bookstore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class MyBookController {
    @Autowired
    private MyBookService myBookService;
    @Autowired
    private BookService bookService;

    public MyBookController(MyBookService myBookService, BookService bookService) {
        this.myBookService = myBookService;
        this.bookService = bookService;
    }
    @GetMapping("/my_book")
    public String myBook(Model model) {
        model.addAttribute("Book", myBookService.getAllBooks());
        return "myBook";
    }
    @RequestMapping("/myList/{id}")
    public String myList(@PathVariable("id") int id){
        Optional<Book> myBookOptional=bookService.getBookById(id);
        if (myBookOptional.isEmpty()){
            throw new IllegalStateException("Book not found");
        }
        Book book=myBookOptional.get();
        MyBook myBook= new MyBook(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice());
        myBookService.addBook(myBook);
        return "redirect:/my_book";
    }
    @RequestMapping("/deleteMyBook/{id}")
    public String deleteMyBook(@PathVariable("id") int id) {
        myBookService.deleteBookById(id);
        return "redirect:/my_book";
    }
    @RequestMapping("/updateMyBook/{id}")
    public String updateMyBook(@PathVariable("id") int id, Model model) {
        Book book=bookService.getBookById(id).orElseThrow();
        model.addAttribute("book", book);
        return "update_book";
    }



}
