package com.example.superreactiveapp.repository;

import com.example.superreactiveapp.model.Book;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BookRepository {

    private final Map<String, Book> datasource = new ConcurrentHashMap<>();

    public BookRepository() {
        datasource.put("1", new Book("1", "Book 1", "Author 1"));
        datasource.put("2", new Book("2", "Book 2", "Author 2"));
        datasource.put("3", new Book("3", "Book 3", "Author 3"));
        datasource.put("4", new Book("4", "Book 4", "Author 4"));
    }

    public Mono<Book> save(Book book) {
        datasource.put(String.valueOf(book.getId()), book);
        return Mono.justOrEmpty(book);
    }

    public Mono<Book> getBookById(String id) {
        return Mono.justOrEmpty(datasource.get(id));
    }

    public Flux<Book> getAllBooks() {
        return Flux.fromIterable(datasource.values());
    }

    public Mono<Void> update(Book book) {
        datasource.put(String.valueOf(book.getId()), book);
        return Mono.justOrEmpty(book).then();
    }
}
