package org.example.myspring.aop;

import org.aspectj.lang.annotation.Pointcut;


public class Pointcuts {
    @Pointcut("execution(public void Library.getBook(String))")
    public void getMethod(){}

    @Pointcut("execution(* Library.return*(..))")
    public void returnMethod(){}

    @Pointcut("getMethod() || returnMethod()")
    public void getOrReturnMethods(){}

    @Pointcut("execution(* Library.*(..))")
    public void allMethods(){}

    @Pointcut("execution(* Library.add*(..))")
    public void addMethod(){}

    @Pointcut("allMethods() && !addMethod()")
    public void addOrReturnMethods(){}

}
