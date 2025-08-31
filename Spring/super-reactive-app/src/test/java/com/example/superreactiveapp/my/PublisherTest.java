package com.example.superreactiveapp.my;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class PublisherTest implements Publisher<Integer> {

    private final int count; // сколько чисел отдать

    public PublisherTest(int count) {
        this.count = count;
    }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        // когда подписывается новый subscriber, создаём Subscription
        subscriber.onSubscribe(new SubscriptionTest(subscriber, count));
    }


}
