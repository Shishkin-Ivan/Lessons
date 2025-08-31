package org.example.springripper.config;

import org.example.springripper.annotation.InjectRandomIntAnnotationBeanPostProcessor;
import org.example.springripper.quoters.Quoter;
import org.example.springripper.quoters.TerminatorQuoter;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Quoter quoter() {
        TerminatorQuoter terminatorQuoter = new TerminatorQuoter();
        terminatorQuoter.setMessage("I'll be back");
        return terminatorQuoter;
    }

    @Bean
    public BeanPostProcessor injectRandomIntAnnotationBeanPostProcessor() {
        return new InjectRandomIntAnnotationBeanPostProcessor();
    }
}
