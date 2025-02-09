package ma.enset.metier;

import ma.enset.aspects.Log;
import ma.enset.aspects.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    @Override
    @Log
    @SecuredByAspect(roles = {"ADMIN","USER"})
    public void process() {
        System.out.println("Business process ...");
    }
    @Override
    @SecuredByAspect(roles = {"ADMIN"})
    public double compute() {
        double data=90;
        System.out.println("Business Computing and returning result ....");
        return data;
    }
}
