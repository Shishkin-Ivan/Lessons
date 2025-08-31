package com.example.mongoproject;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/dogs")
@RequiredArgsConstructor
public class DogController {
    private final DogRepository dogRepository;

    @GetMapping
    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Dog> getDogByName(@PathVariable String name) {
        var dog = dogRepository.findByName(name);
        if (dog == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return new ResponseEntity<>(dog, HttpStatus.OK);
    }

    @PostMapping
    public void putDogIntoDB(@RequestBody Dog dog) {
        dog.setId(UUID.randomUUID());
        dogRepository.save(dog);
    }
}
