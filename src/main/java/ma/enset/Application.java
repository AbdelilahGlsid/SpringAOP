package ma.enset;

import ma.enset.metier.IMetier;
import ma.enset.metier.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(value = {"ma.enset"})
public class Application {
    public static void main(String[] args) {
        try{
            SecurityContext.authenticateUser("root","1234",new String[]{"USER"});

            ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
            IMetier metier=context.getBean(IMetier.class);

            System.out.println("********************");
            System.out.println(metier.getClass().getName());
            System.out.println("********************");

            metier.process();
            System.out.println(metier.compute());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}