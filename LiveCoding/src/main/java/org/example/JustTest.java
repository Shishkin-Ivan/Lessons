package org.example;

import java.util.Map;

public class JustTest {
    public static void main(String[] args) {
        System.out.println(

                Map.of(1, "one", 2, "two", 3, "three").entrySet().stream()

                        .filter(entry -> entry.getValue().length() > 3)

                        .map(Map.Entry::getKey)

                        .findFirst() .map(x -> "result = " + x)

                        .orElse("result = null")

        );
    }
}
