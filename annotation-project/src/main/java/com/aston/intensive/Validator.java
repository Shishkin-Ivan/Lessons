package com.aston.intensive;

import java.lang.reflect.Field;

public class Validator {
    public static void validate(Object object) throws IllegalAccessException {
        for (Field field : object.getClass().getDeclaredFields()) {
            NotEmpty notEmpty = field.getAnnotation(NotEmpty.class);
            if (notEmpty != null) {
                field.setAccessible(true); // даем доступ к полю, помеченному аннотацией @NotEmpty
                Object value = field.get(object); // получаем поле
                if (value != null || value.toString().isEmpty()) {
                    throw new RuntimeException(notEmpty.message());
                }
            }
        }

    }
}
