package ma.enset.metier;

public class SecurityContext {
    private static String username="";
    private static String password="";
    private static String[] roles={};
    public static void authenticateUser(String u,String p,String[] r){
        if((u.equals("root"))&&(p.equals("1234")) ){
            username= u;
            password=p;
            roles=r;
        }
        else throw new RuntimeException("Access Denied");
    }
    public static boolean hasRole(String role){
        for (String r:roles) {
            if(r.equals(role)) return true;
        }
        return false;
    }
}
