package org.example.myspring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Pet {

    @Value("${dog.name}")
    private String name;

    public Dog() {
        System.out.println("Dog bean is created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Dog set name is " + name);
        this.name = name;
    }

    @PostConstruct
    public void init(){
        System.out.println("Dog init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Dog destroy");
    }

    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }

}
