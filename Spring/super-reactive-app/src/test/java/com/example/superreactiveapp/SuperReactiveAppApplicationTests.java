package com.example.superreactiveapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

@SpringBootTest
class SuperReactiveAppApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void simpleMonoExample() {
        Flux<Integer> source = Flux.just(1, 2, 3);

        Flux<String> result = source
                .map(i -> "Элемент: " + (i * 10)); // трансформация элементов

        result.subscribe(
                value -> System.out.println("Получено: " + value),     // onNext
                error -> System.err.println("Ошибка: " + error),       // onError
                () -> System.out.println("Завершено успешно")          // onComplete
        );
    }

    @Test
    void simpleFluxExample() {
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        //fluxColors.log();
        fluxColors.log().filter(s -> s.equals("green")).subscribe(System.out::println);
    }

    @Test
    void mapExample() {
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        fluxColors.map(color -> color.charAt(0)).subscribe(System.out::println);
    }

    @Test
    void zipExample() {
        Flux<String> fluxFruits = Flux.just("apple", "pear", "plum");
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        Flux<Integer> fluxAmounts = Flux.just(10, 20, 30);
        Flux.zip(fluxFruits, fluxColors, fluxAmounts).subscribe(System.out::println);
    }

    @Test
    void myTest(){
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        fluxColors.subscribe(System.out::println);
    }


    // Error
    @Test
    public void onErrorExample() {
        Flux<String> fluxCalc = Flux.just(-1, 0, 1)
                .map(i -> "10 / " + i + " = " + (10 / i));

        fluxCalc.subscribe(value -> System.out.println("Next: " + value),
                error -> System.err.println("Error: " + error));
    }

    @Test
    public void onErrorReturnExample() {
        Flux<String> fluxCalc = Flux.just(-1, 0, 1)
                .map(i -> "10 / " + i + " = " + (10 / i))
                .onErrorReturn(ArithmeticException.class, "Division by 0 not allowed");

        fluxCalc.subscribe(value -> System.out.println("Next: " + value),
                error -> System.err.println("Error: " + error));
    }

    @Test
    public void stepVerifierTest() {
        Flux<String> fluxCalc = Flux.just(-1, 0, 1)
                .map(i -> "10 / " + i + " = " + (10 / i));
        StepVerifier.create(fluxCalc)
                .expectNextCount(1)
                .expectError(ArithmeticException.class)
                .verify();
    }

    @Test
    public void publishSubscribeExample() {
        Scheduler schedulerA = Schedulers.newParallel("Scheduler A");
        Scheduler schedulerB = Schedulers.newParallel("Scheduler B");
        Scheduler schedulerC = Schedulers.newParallel("Scheduler C");

        Flux.just(1)
                .map(i -> {
                    System.out.println("First map: " + Thread.currentThread().getName());
                    return i;
                })
                .subscribeOn(schedulerA)
                .map(i -> {
                    System.out.println("Second map: " + Thread.currentThread().getName());
                    return i;
                })
                .publishOn(schedulerB)
                .map(i -> {
                    System.out.println("Third map: " + Thread.currentThread().getName());
                    return i;
                })
                .subscribeOn(schedulerC)
                .map(i -> {
                    System.out.println("Fourth map: " + Thread.currentThread().getName());
                    return i;
                })
                .publishOn(schedulerA)
                .map(i -> {
                    System.out.println("Fifth map: " + Thread.currentThread().getName());
                    return i;
                })
                .blockLast();
    }

}
