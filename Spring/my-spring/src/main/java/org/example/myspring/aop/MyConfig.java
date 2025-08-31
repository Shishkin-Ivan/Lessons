package org.example.myspring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.example.myspring.aop")
@EnableAspectJAutoProxy
public class MyConfig {
}
