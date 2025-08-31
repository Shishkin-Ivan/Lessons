package org.example.lesson7;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Создаем людей
        Person alice = new Person("Alice", 25, "New York", List.of("Java", "Python"));
        Person bob = new Person("Bob", 30, "Chicago", List.of("C++", "JavaScript"));
        Person charlie = new Person("Charlie", 20, "New York", List.of("Python", "SQL"));
        Person david = new Person("David", 35, "Chicago", List.of("Java", "Kotlin"));
        Person eve1 = new Person("Eve", 28, "Los Angeles", List.of("JavaScript", "HTML"));
        Person eve2 = new Person("Eve", 45, "Los Angeles", List.of("JavaScript", "HTML"));

        // Добавляем друзей
        alice.addFriend(bob);
        alice.addFriend(charlie);
        bob.addFriend(david);
        charlie.addFriend(eve1);
        david.addFriend(alice);

        List<Person> people = List.of(alice, bob, charlie, david, eve1, eve2);

        // Здесь будем выполнять задачи

//        1. Базовые операции
//        1.1. Фильтрация по возрасту
//        Отфильтруйте людей старше 25 лет и соберите в новый список.
         List<Person> peopleList = people.stream().filter(p -> p.getAge() > 25).collect(Collectors.toList());

//        1.2. Преобразование имен
//        Создайте список имен всех людей в верхнем регистре.
        people.stream().map(s -> s.getName().toUpperCase()).toList();

//        1.3. Сортировка
//        Отсортируйте людей по имени(натурально) и возрасту (по убыванию).
        //TODO: Сохранить себе
        people.stream().sorted(Comparator.comparing(Person::getName).thenComparing((p1, p2) -> p2.getAge()-p1.getAge())).forEach(System.out::println);

//        2. Группировка и статистика
//        2.1. Группировка по городу
//        Сгруппируйте людей по городам (Map<String, List<Person>>).
        people.stream().collect(Collectors.groupingBy(Person::getCity));
//
//        2.2. Средний возраст по городам
//        Вычислите средний возраст людей в каждом городе (Map<String, Double>).
        System.out.println(people.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.averagingDouble(Person::getAge))));
//
//        2.3. Самый молодой и самый старый
//        Найдите самого молодого и самого старого человека в списке.
        //TODO: Почитать поподробней
        System.out.println(people.stream().collect(Collectors.summarizingDouble(Person::getAge)));

//        3. Поиск и проверки
//        3.1. Есть ли человек из определенного города?
//                Проверьте, есть ли хотя бы один человек из "Los Angeles".
        people.stream().filter(p -> p.getCity().equals("Los Angeles")).findAny().ifPresent(System.out::println);
        //TODO: почитать про anyMatch
//
//        3.2. Все ли старше 18 лет?
//                Проверьте, всем ли людям в списке больше 18 лет.
        //TODO: зафиксировапть себе
        System.out.println(people.stream().allMatch(s -> s.getAge() > 18));

//        3.3. Поиск по имени
//        Найдите первого человека с именем, начинающимся на "E".
        people.stream().filter(s -> s.getName().startsWith("E")).findFirst().ifPresent(System.out::println);

//        4. Продвинутые операции
//        4.1. Объединение имен
//        Соберите все имена в одну строку через запятую:
//        "Alice, Bob, Charlie, ..."
        System.out.println(people.stream().map(Person::getName).reduce((p1, p2) -> p1 + ", " + p2).get());



//
//        4.2. Разделение на две группы
//        Разделите людей на две группы:


//        младше 30 лет
//
//        30 лет и старше
        //TODO: узнать в чем разница
        System.out.println(people.stream().collect(Collectors.groupingBy(s -> s.getAge() > 30)));
        System.out.println(people.stream().collect(Collectors.partitioningBy(s -> s.getAge() > 30)));

//        4.3. Самый популярный город
//        Найдите город, в котором живет больше всего людей
//        Map<String, Long> map = people.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));
//        map.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);

//        5. Комплексные задачи
//        5.1. Имена людей старше 25 из определенного города
//        Выведите имена людей старше 25 лет, живущих в "Chicago".

//        5.2. Уникальные города
//        Получите список уникальных городов из списка людей.

    }
}