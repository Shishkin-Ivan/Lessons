package org.example.springripper;

import org.example.springripper.config.Config;
import org.example.springripper.quoters.Quoter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringRipperApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringRipperApplication.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.getBean(Quoter.class).sayQuote();
    }
}
