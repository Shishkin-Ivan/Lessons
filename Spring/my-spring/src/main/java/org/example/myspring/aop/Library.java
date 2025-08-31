package org.example.myspring.aop;

import org.springframework.stereotype.Component;

@Component
public class Library {

    public Library() {
        System.out.println("Library is created");
    }

    public void getBook(String bookName) {
        System.out.println("Взял книгу " + bookName);
    }

    public void returnBook(String bookName) {
        System.out.println("Вернул книгу " + bookName);
    }

    public void addBook(String bookName) {
        System.out.println("Добавил книгу " + bookName);
    }

}
