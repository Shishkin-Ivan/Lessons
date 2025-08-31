package org.example.lesson4;

import java.util.Comparator;
import java.util.List;

// Есть класс студента с name и avgMark(средняя оценка).
// Нужно с помощью стрима найти топ 3 студентов с лучшей средней оценкой
public class Test {

    public record Student(
            String name,
            int mark,
            float averageMark
    ) {}

    static List<Student> students = List.of(
            new Student("Alexandr", 3, 3.9f),
            new Student("Bradley", 2, 3.1f),
            new Student("Colin", 5, 4.5f),
            new Student("David", 4, 4.1f),
            new Student("Elvis", 1, 1.1f)
    );

    public static void main(String[] args) {
        List<Student> top3 = students.stream()
                .sorted(Comparator.comparingDouble(Student::averageMark).reversed())
                .limit(3)
                .toList();
    }
}
