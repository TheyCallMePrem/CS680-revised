package edu.umb.cs680.hw05;

public class LoggedOut implements State{
    private static SecurityContext ctx;
    private static LoggedOut LOobject=null;
    private static State  LOState= new LoggedOut();
    @Override
    public void login(EncryptedString pwd){
        System.out.println("login() of state LoggedOut");     
        if (Authenticator.authenticate(ctx, pwd) ){
            System.out.println("debug1");
            // LoggedIn.CreateInstance(ctx);
            ctx.changeState(LoggedIn.getInstance());
            // System.out.println("State changed");
        }   
        else{
            //error auth handling
            System.out.println("Wrong ID/password");
        }                                                                             
    }

    @Override
    public void logout(){
        System.out.println("logout() of state LoggedOut");
        //empty
    }
    //Method to change state to LoggedOut
    public static void setSecurityContext(SecurityContext ctx) {
        System.out.println("here!11111111111111111111111111111");
		LoggedOut.ctx = ctx;
	}   
    public LoggedOut(){
    }
    public static State getInstance(){
        // create object if it's not already created --- sINGLETON

        if (LOState == null) {
			LOState = new LoggedOut();
		}
		return LOState;
    }

    // public static State logoutState(){
    //     return new LoggedOut(ctx);
    // }
}


class Authenticator{
    public static boolean authenticate(SecurityContext ctx, EncryptedString password){

        System.out.println("Invoked authenticator");
        return true;
    }
}