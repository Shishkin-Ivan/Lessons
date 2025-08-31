package com.example.superreactiveapp.my;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class SubscriptionTest implements Subscription {

    private final Subscriber<? super Integer> subscriber;
    private final int count;
    private final AtomicLong requested = new AtomicLong(0);
    private final AtomicBoolean canceled = new AtomicBoolean(false);
    private int current = 1;

    public SubscriptionTest(Subscriber<? super Integer> subscriber, int count) {
        this.subscriber = subscriber;
        this.count = count;
    }

    @Override
    public void request(long l) {
        if (l <= 0) {
            subscriber.onError(new IllegalArgumentException("3.9: request must be > 0"));
            return;
        }
        System.out.println("requested: " + l);
        requested.addAndGet(l);
        emit();
    }

    @Override
    public void cancel() {
        canceled.set(true);
    }

    private void emit() {
        while (requested.get() > 0 && current <= count && !canceled.get()) {
            subscriber.onNext(current++);
            requested.decrementAndGet();
        }
        if (current > count && !canceled.get()) {
            subscriber.onComplete();
        }
    }

}
