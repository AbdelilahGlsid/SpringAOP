package ma.enset.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.logging.Logger;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LoggingAspect {
//    @Before("execution(* ma.enset.metier..*(..))")
//    public void log(){
//        System.out.println("From Login Aspect ... Before");
//    }

    Logger logger=Logger.getLogger(LoggingAspect.class.getName());
//    @Around("execution(* ma.enset.metier..*(..))")
    @Around("@annotation(ma.enset.aspects.Log)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long t1 = System.currentTimeMillis();
        logger.info("From Logging Aspects ... Before " + proceedingJoinPoint.getSignature());
        Object result = proceedingJoinPoint.proceed();
        logger.info("From Logging Aspects ... After " + proceedingJoinPoint.getSignature());
        long t2 = System.currentTimeMillis();
        logger.info("Duration :" + (t2 - t1));
        return result;
    }

}
