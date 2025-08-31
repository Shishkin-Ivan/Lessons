package org.example.myspring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class AspectClassSecond {

    @Before("Pointcuts.getMethod()")
    public void beforeGetAdvice() {
        System.out.println("beforeGetAdvice from AspectClassSecond");
    }
}
