package org.example.my;

public class StringPoolTest {
    public static void main(String[] args) {
        String a = "Cat";
        String b = "Cat";
        String c = new String("Cat");
        String d = new String("Cat");
        System.out.println("a==b: " + (a==b));
        System.out.println("a==c: " + (a==c));
        System.out.println("b==c: " + (b==c));
        System.out.println("c==d: " + (c==d));
        System.out.println("a==d: " + (a==d));

        c = c.intern();
        System.out.println("intern");
        System.out.println("a==b: " + (a==b));
        System.out.println("a==c: " + (a==c));
        System.out.println("b==c: " + (b==c));
        System.out.println("c==d: " + (c==d));
        System.out.println("a==d: " + (a==d));
    }
}
