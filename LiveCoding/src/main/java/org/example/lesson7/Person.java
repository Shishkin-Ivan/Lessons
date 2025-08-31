package org.example.lesson7;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private int age;
    private String city;
    private List<Person> friends;
    private List<String> skills;

    public Person(String name, int age, String city, List<String> skills) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.friends = new ArrayList<>();
        this.skills = skills;
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCity() { return city; }
    public List<Person> getFriends() { return friends; }
    public List<String> getSkills() { return skills; }

    public void addFriend(Person friend) {
        friends.add(friend);
    }

    @Override
    public String toString() {
        return name + " (" + age + ", " + city + ")";
    }
}
