package ma.enset.aspects;

import ma.enset.metier.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AuthorizationAspect {
    @Around(value="@annotation(securedByAspect)",
            argNames = "proceedingJoinPoint,securedByAspect")
    public Object log(ProceedingJoinPoint proceedingJoinPoint,
                      SecuredByAspect securedByAspect) throws Throwable {
        String[] roles=securedByAspect.roles();
        boolean authorized=false;
        for (String r:roles){
            if(SecurityContext.hasRole(r)){
                authorized=true;
                break;
            }
        }
        if (authorized == true){
            Object result = proceedingJoinPoint.proceed();
            return result;
        }
        throw new RuntimeException("Not Authorized 403" + proceedingJoinPoint.getSignature());
    }
}
