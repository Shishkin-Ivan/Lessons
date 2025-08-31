package com.example.superreactiveapp.my;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.stereotype.Component;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

@Component
public class MyReactiveTest {
    public static void main(String[] args) {
        //PublisherTest publisher = new PublisherTest(10);
        //SubscriberTest subscriber = new SubscriberTest();
        //
        //publisher.subscribe(subscriber);


        //Flux<String> fluxColors = Flux.just("red", "green", "blue");

        simpleFluxExample2();

    }

    public static void simpleFluxExample() {
        Flux<Integer> source = Flux.just(1, 2, 3);

        Flux<String> result = source
                .map(i -> "Элемент: " + (i * 10)); // трансформация элементов

        result.subscribe(
                value -> System.out.println("Получено: " + value),    // onNext
                error -> System.err.println("Ошибка: " + error),  // onError
                () -> System.out.println("Завершено успешно")               // onComplete
        );
    }

    public static void simpleFluxExample2() {
        Flux<Integer> source = Flux.just(1, 2, 3);

        Flux<String> result = source
                .map(i -> "Элемент: " + (i * 10)); // трансформация элементов

        result.subscribe(new BaseSubscriber<String>() {
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                System.out.println("Подписались!");
                request(2); // сразу просим только 2 элемент
            }

            @Override
            protected void hookOnNext(String value) {
                System.out.println("Получено: " + value);

                // имитируем "постепенную обработку"
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // когда закончили обрабатывать — просим ещё один
                request(1);
            }

            @Override
            protected void hookOnComplete() {
                System.out.println("Готово!");
            }
        });
    }

}
