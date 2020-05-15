package ru.itis.semestrovka.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
@Slf4j
public class LoggerService {

    @Before(value = "execution(* ru.itis.semestrovka.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Invoke method: " + joinPoint.getSignature().getDeclaringTypeName() + "," +
                joinPoint.getSignature().getName());
        log.info("Date: " + new Date());
        log.info("Parameters: ");
        for (Object arguments : joinPoint.getArgs()) {
            log.info(arguments + "\t");
        }
    }
}