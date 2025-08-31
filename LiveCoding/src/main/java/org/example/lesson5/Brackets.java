package org.example.lesson5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Brackets {

    public static void main(String[] args) {
        final var brackets = List.of(
                "()",       // true
                "{()}",             // true
                "{([])}",           // true
                "()[]",             // true
                "{()[]}",           // true
                "[}",               // false
                "(){]",             // false
                "{](}",             // false
                "{{]",              // false
                "][",               // false
                "[[",               // false
                "]]",               // false
                ""                  // false
        );

        brackets.stream()
                .map(Brackets::checkString)
                .forEach(System.out::println);
    }

    public static boolean checkString(final String string) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stk = new Stack<>();

        for(char c: string.toCharArray()) {
            if(map.containsKey(c)){
                stk.push(c);
            }
            if(map.containsValue(c)) {
                if(stk.isEmpty() || map.get(stk.pop()) != c) {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}
