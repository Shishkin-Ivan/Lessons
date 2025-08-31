package org.example.myspring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringApplication2 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context;
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Pet pet = context.getBean("myDog", Pet.class);

        pet.say();

        context.close();
    }
}
