package com.spring.web.services;

import com.spring.web.entities.Book;
import com.spring.web.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices {

    private final BookRepository bookRepository;

    @Autowired
    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBook () {
        return (List<Book>) this.bookRepository.findAll();
    }

    public Optional<Book> getBookById(Integer id) {
        return this.bookRepository.findById(id);
    }

    public Book addBook (Book book) {
      return this.bookRepository.save(book);
    }

    public void deleteBook (int id) {
        this.bookRepository.deleteById(id);
    }

    public Book updateBook (Book book, int id){
        book.setId(id);
        this.bookRepository.save(book);
        return book;
    }

}
