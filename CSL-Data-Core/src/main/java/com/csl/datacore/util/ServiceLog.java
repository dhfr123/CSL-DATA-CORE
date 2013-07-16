/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csl.datacore.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 *
 * @author Deni Husni FR
 */
@Aspect
public class ServiceLog {

    private static final Logger LOGGER = Logger.getLogger(ServiceLog.class);

    @Before("execution(* com.csl.datacore.service.serviceimplementasi.*.*(..))")
    public void logBeforeService(JoinPoint joinPoint) {
        LOGGER.info(" ---------- Service Executed BEGIN By ADMIN ----------");
        LOGGER.info("BEFORE Methode - Class Name :" + joinPoint.getTarget().getClass().getName());
        LOGGER.info("BEFORE Methode - Method Name :" + joinPoint.getSignature().getName() + "()");
          LOGGER.info(" ---------- Service Executed BEGIN By ADMIN ----------");
    }

    @Before("execution(* com.csl.datacore.dao.daoimplementasi.*.*(..))")
    public void logBeforeDao(JoinPoint joinPoint) {
        LOGGER.info(" ---------- DAO Executed BEGIN By ADMIN ----------");
        LOGGER.info("BEFORE Methode - Class Name :" + joinPoint.getTarget().getClass().getName());
        LOGGER.info("BEFORE Methode - Method Name :" + joinPoint.getSignature().getName() + "()");
       LOGGER.info(" ---------- DAO Executed BEGIN By ADMIN ----------");
    }

    @AfterReturning(pointcut = "execution(* com.csl.datacore.service.serviceimplementasi.*.*(..))",
            returning = "result")
    public void logAfterReturnService(JoinPoint joinPoint, Object result) {
        LOGGER.info(" ---------- Service Executed DONE By ADMIN ----------");
        LOGGER.info("AFTER Methode - Class Name :" + joinPoint.getTarget().getClass().getName());
        LOGGER.info("AFTER Methode - Method Name :" + joinPoint.getSignature().getName() + "()");
          LOGGER.info(" ---------- Service Executed DONE By ADMIN ----------");
    }

    @AfterReturning(pointcut = "execution(* com.csl.datacore.dao.daoimplementasi.*.*(..))",
            returning = "result")
    public void logAfterReturnDao(JoinPoint joinPoint, Object result) {
        LOGGER.info(" ---------- DAO Executed DONE By ADMIN ----------");
        LOGGER.info("AFTER Methode - Class Name :" + joinPoint.getTarget().getClass().getName());
        LOGGER.info("AFTER Methode - Method Name :" + joinPoint.getSignature().getName() + "()");
        LOGGER.info(" ---------- DAO Executed DONE By ADMIN ----------");
    }
}
