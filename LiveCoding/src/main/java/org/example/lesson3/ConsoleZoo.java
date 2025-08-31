package org.example.lesson3;

import java.util.List;

public class ConsoleZoo {

    public static void main(String[] args) {
        List.of("dog", "cat", "hamster")
                .stream()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.length() <= 3;
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                }).sorted()
                .forEach(s -> {
                    System.out.println("forEach: " + s);
                });

        //"filter: dog"
        //"map: dog"
        //"filter: cat"
        //"map: cat"
        //"filter: hamster"

        //"forEach: CAT"
        //"forEach: DOG"
    }
}