package com.xoriant.banking.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.xoriant.banking.command.UserDTO;

//import org.aspectj.lang.annotation.Aspect;
import lombok.extern.slf4j.Slf4j;

@EnableAspectJAutoProxy
@Component
@Slf4j
@Aspect

public class LogAspect {
	    
	
     
	     @Around("execution( * com.xoriant.banking.controller.UserController.loginUser(..)) && " +
	    		    "args( userData)")
		 public Object logAroundUserName(ProceedingJoinPoint proceedingJoinPoint, UserDTO userData) throws Throwable {
	    	 System.out.println("sefgsdsgdgdggfbgggggggggggggggggg");
	    	 System.out.println(proceedingJoinPoint + " -> " + userData.getUserName());
	    	    return proceedingJoinPoint.proceed(new Object[] { "Hello AOP!" });
		}
	     
	    
	
	
}