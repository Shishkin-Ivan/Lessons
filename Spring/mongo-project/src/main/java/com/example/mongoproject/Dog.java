package com.example.mongoproject;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Setter
@Getter
@Document
public class Dog {

    @Id
    private UUID id;

    // Все имена будут уникальны
    // тогда, мы сможем делать по этому полю выборку
    @Indexed(unique=true)
    private String name;

    private Integer age;
}
