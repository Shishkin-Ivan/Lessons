package com.example.superreactiveapp.controller;

import com.example.superreactiveapp.model.Book;
import com.example.superreactiveapp.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{id}")
    public Mono<Book> getBookById(@PathVariable String id) {
        return bookRepository.getBookById(id);
    }

    @GetMapping
    public Flux<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @PostMapping
    public Mono<Book> createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PatchMapping
    public Mono<Void> updateBook(@RequestBody Book book) {
        return bookRepository.update(book);
    }
}
