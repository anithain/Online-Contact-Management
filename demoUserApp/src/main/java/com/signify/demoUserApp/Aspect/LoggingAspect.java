package com.signify.demoUserApp.Aspect;

import org.aspectj.lang.annotation.Aspect;

import com.signify.demoUserApp.entity.Customer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.signify.demoUserApp.controller.UserController.addUser(..))")
    public void createUserPointcut() {}

    @Pointcut("execution(* com.signify.demoUserApp.controller.UserController.updateUser(..))")
    public void updateUserPointcut() {}

    @AfterReturning(pointcut = "createUserPointcut()", returning = "result")
    public void afterUserCreated(Customer result) {
        System.out.println("User created: " + result);
    }

    @AfterReturning(pointcut = "updateUserPointcut()", returning = "result")
    public void afterUserUpdated(Customer result) {
        System.out.println("User updated: " + result);
    }

    @Before("updateUserPointcut()")
    public void beforeUserUpdated(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Customer user = (Customer) args[1];
        System.out.println("Updating user: " + user);
    }
}
