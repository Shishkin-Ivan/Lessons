package org.example.myspring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class AspectClass {

    @Before("Pointcuts.getMethod()")
    public void beforeGetAdvice() {
        System.out.println("beforeGetAdvice from AspectClass");
    }

    @Before("Pointcuts.returnMethod()")
    public void beforeReturnAdvice() {
        System.out.println("beforeReturnAdvice from AspectClass");
    }

    @Before("Pointcuts.getOrReturnMethods()")
    public void beforeGetOrReturnAdvice() {
        System.out.println("beforeGetOrReturnAdvice from AspectClass");
    }

    @After("Pointcuts.addOrReturnMethods()")
    public void afterAddOrReturnAdvice() {
        System.out.println("afterAddOrReturnAdvice from AspectClass");
    }

}
