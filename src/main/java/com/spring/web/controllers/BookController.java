package com.spring.web.controllers;

import com.spring.web.entities.Book;
import com.spring.web.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final BookServices bookServices;

    @Autowired
    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }


    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> list =  this.bookServices.getAllBook();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping( "/books/{id}")
    public ResponseEntity<Optional<Book>>  getBook ( @PathVariable("id") int id) {
        Optional<Book> book =  this.bookServices.getBookById(id);

        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PutMapping("/books")
    public ResponseEntity<Book> addBook (Book book) {
        Book result = this.bookServices.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity deleteBook (@PathVariable int id) {
        this.bookServices.deleteBook(id);
        return ResponseEntity.status(HttpStatus.De)
    }

    @PutMapping("/books/{id}")
    public Book updateBook (@RequestBody Book book, @PathVariable int id) {
        return this.bookServices.updateBook(book, id);
    }


}
