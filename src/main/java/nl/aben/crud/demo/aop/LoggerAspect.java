package nl.aben.crud.demo.aop;


import nl.aben.crud.demo.model.Politician;
import nl.aben.crud.demo.model.Student;
import nl.aben.crud.demo.model.emp.Employee;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Before("@annotation(nl.aben.crud.demo.annotation.LogObjectBefore)")
    public void logBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Politician) {
                Politician politician = (Politician) arg;
                log.info("******* Politician before :: {}", politician);
            } else if (arg instanceof Employee) {
                Employee employee = (Employee) arg;
                log.info("******* Employee before :: {}", employee);
            } else if (arg instanceof Student) {
                Student student = (Student) arg;
                log.info("******* Student before :: {}", student);
            }
        }
    }

    @AfterReturning(value = "@annotation(nl.aben.crud.demo.annotation.LogObjectAfter)", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        Object[] args = joinPoint.getArgs();
        if (Objects.nonNull(result)) {
            if (result instanceof ResponseEntity) {
                ResponseEntity responseEntity = (ResponseEntity) result;

                if (responseEntity.getStatusCode().value() == 200)
                    log.info("******* Returning object :: {}", responseEntity.getBody());
                else
                    log.error("Something went wrong while logging...!");
            }
        }
    }
}
