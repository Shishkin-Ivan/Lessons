package com.aston.intensive;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void  processLogging(Class<?> someClass){
        for(Method method : someClass.getDeclaredMethods()){
            Log log = method.getAnnotation(Log.class);
            if(log != null){
                String message = "Logging Method: " + method.getName() + " , level: " + log.level();
                System.out.println(message);
            }
        }
    }
}
