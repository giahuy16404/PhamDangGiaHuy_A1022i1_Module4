package com.example.library.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int count = 0;
    //Đếm các hoạt động sách trong thư viện
    @After("execution(* com.example.library.controller.LibraryController.*(..))")
    public void count(JoinPoint joinPoint){
        count++;
        System.out.println("--------------AOP------------------");
        System.out.println("-- Method thực hiện " + joinPoint.getSignature().getName());
        System.out.println("-- số lần truy cập " + count);
    }
}
