package com.example.superreactiveapp.my;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.stereotype.Component;

public class SubscriberTest implements Subscriber<Integer> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("SubscriberTest Подписались!");
        this.subscription = subscription;

        // попросим сначала 5 элементов
        subscription.request(5);
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("SubscriberTest Получили: " + integer);
        // когда получили элемент — запросим следующий
        // (или можно запросить пачками)
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("SubscriberTest Ошибка: " + throwable);
    }

    @Override
    public void onComplete() {
        System.out.println("SubscriberTest Готово!");
    }
}
