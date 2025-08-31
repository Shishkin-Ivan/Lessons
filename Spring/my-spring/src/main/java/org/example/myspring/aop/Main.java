package org.example.myspring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context;
        context = new AnnotationConfigApplicationContext("org.example.myspring.aop");

        Library library = context.getBean("library", Library.class);
        library.getBook("Some book");
        //library.returnBook("Some book");
        //library.addBook("Some book 3");

        context.close();
    }
}
