package org.example.lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CollectionTest {

    public static void main(String[] args) {
        final var students = new ArrayList<>(Arrays.asList(
                new Student("Иванов", "Иван", "Иванович", "Математика", false),
                new Student("Петров", "Петр", "Петрович", "Физика", false),
                new Student("Сидоров", "Сидор", "Сидорович", "Физика", true)
        ));

        // 1. Выполнить сортировку списка абитуриентов в алфавитном порядке по убыванию
        List<Student> sorterStudents = students.stream()
                .sorted(Comparator.comparing(Student::getLastName).reversed())
                            .collect(Collectors.toList());

        Random random = new Random();

        students.stream().forEach(s -> s.setAdmission(random.nextBoolean()));

        Map<String, Set<Student>> map = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getSpecialty, Collectors.toCollection(TreeSet::new)));

        Map<Boolean, String> map2 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::isAdmission,
                        Collectors.mapping(Student::getLastName, Collectors.joining(", "))));
    }

    public static class Student {
        private final String lastName;
        private final String firstName;
        private final String middleName;
        private final String specialty;
        private boolean admission;

        public Student(
                final String lastName,
                final String firstName,
                final String middleName,
                final String specialty,
                final boolean admission
        ) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.middleName = middleName;
            this.specialty = specialty;
            this.admission = admission;
        }

        public String getLastName() {
            return lastName;
        }

        public String getSpecialty() {
            return specialty;
        }

        public boolean isAdmission() {
            return admission;
        }

        public void setAdmission(boolean admission) {
            this.admission = admission;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "lastName='" + lastName + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", middleName='" + middleName + '\'' +
                    ", specialty='" + specialty + '\'' +
                    ", admission=" + admission +
                    '}';
        }
    }
}