package org.example.lesson6;

/*    Условие:
Даны две строки s и t. Верните true, если строка t является анаграммой строки s, и false в противном случае.

Определение:
Анаграмма — это слово или фраза, образованная путём перестановки букв другого слова или фразы,
 как правило, с использованием всех исходных букв ровно один раз.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 */
public class Task6 {

    public static void main(String[] args) {
        String str1 = "anagram";
        String str2 = "nagaram";

        System.out.println(isAnagram(str1, str2));
    }

    private static boolean isAnagram(String str1, String str2) {
            return false;
    }
}
