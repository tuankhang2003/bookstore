package com.bookStore.bookstore.service;

import com.bookStore.bookstore.book.MyBook;
import com.bookStore.bookstore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MyBookService {
    private MyBookRepository myBookRepository;
    @Autowired
    public MyBookService(MyBookRepository myBookRepository) {
        this.myBookRepository = myBookRepository;
    }
    public List<MyBook> getAllBooks() {
        return myBookRepository.findAll();
    }
    public void addBook(MyBook myBook) {
        if (myBookRepository.existsById(myBook.getId())){
            return;
        }
        myBookRepository.save(myBook);
    }
    public void saveBook(MyBook myBook) {
        myBookRepository.save(myBook);
    }
    public Optional<MyBook> getMyBookById(int id) {
        return myBookRepository.findById(id);
    }
    public void deleteBookById(int id) {
        if (!myBookRepository.existsById(id)){
            throw new IllegalStateException("Book does not exist");
        }
        myBookRepository.deleteById(id);
    }
    @Transactional
    public void updateMyBook(int id, String title, String author, double price ) {
        Optional<MyBook> myBook = myBookRepository.findById(id);
        if (!myBook.isPresent()){
            return;
        }
        myBook.get().setTitle(title);
        myBook.get().setAuthor(author);
        myBook.get().setPrice(price);
        myBookRepository.save(myBook.get());
    }
}
