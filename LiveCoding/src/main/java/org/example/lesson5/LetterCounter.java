package org.example.lesson5;


import java.util.List;

// Написать метод, который в полученной на вход произвольной строке (например aaabbrrrrfll),
// считает количество подряд идущих символов и на выходе возращает сторку вида: 3a;2b;4r;1f;2l;a2
public class LetterCounter {
    public static final List<String> STRINGS = List.of(
            "aaabbrrrrfll",     // 3a;2b;4r;1f;2l
            "bbrrrrfll",        // 2b;4r;1f;2l
            "bbrrrrfl",         // 2b;4r;1f;1l
            "aaabbrrrrfllaa",   // 3a;2b;4r;1f;2l;a2
            "aaabbrrrrbfllaa",  // 3a;2b;4r;1b;1f;2l;a2
            "a",                // exception
            ""                  // exception
    );

    public static void main(final String[] args) {
        STRINGS.stream()
                .map(LetterCounter::count)
                .forEach(System.out::println);
    }

    public static String count(final String string) {
        if (string == null || string.length() == 0){
            throw new IllegalArgumentException();
        }

        StringBuilder result = new StringBuilder();

        int count = 1;

        for(int i = 1; i < string.length(); i++) {
            if(string.charAt(i) == string.charAt(i-1)) {
                count++;
            } else{
                result.append(count).append(string.charAt(i-1)).append(";");
                count = 1;
            }
        }
        result.append(count).append(string.charAt(string.length()-1));
        return result.toString();
    }
}