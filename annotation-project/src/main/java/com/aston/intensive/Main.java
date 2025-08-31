package com.aston.intensive;

public class Main {
    public static void main(String[] args) {
        //AnnotationProcessor.processLogging(Logger.class);
        try {
            User user = new User("", "");
            Validator.validate(user);
        } catch (Exception e){
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}