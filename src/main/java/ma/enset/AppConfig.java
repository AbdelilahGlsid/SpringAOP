package ma.enset;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"ma.enset"})
//@ComponentScan(value = {"ma.enset.metier","ma.enset.aspects"})
public class AppConfig {
}
