package org.example.springripper.quoters;

import jakarta.annotation.PostConstruct;
import org.example.springripper.annotation.InjectRandomInt;

public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct
    public void init() {
        System.out.println("Bean was initialized. repeat = " + repeat);
    }


    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
