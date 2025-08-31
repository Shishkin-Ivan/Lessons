package org.example.lesson4;

import java.util.Arrays;

public class WordWeight {

    public static void main(final String[] args) {
        // Every word has weight. You need to find the most weight word. The right answer is python.
        // java: j = 106, a = 97, v = 118, a = 97, sum = 418
        // python: p = 112, y = 121, t = 116, h = 104, o = 111, n = 110, sum = 674
        // c++: c = 99, + = 43, + = 43, sum = 185

        final String[] words = {"java", "python", "c++"};
        System.out.println(findMostWeightWord(words));
    }

    private static String findMostWeightWord(final String[] words) {
        return Arrays.stream(words)
                .max((w1, w2) -> Integer.compare(w1.chars().sum(), w2.chars().sum())).get();

    }
}

