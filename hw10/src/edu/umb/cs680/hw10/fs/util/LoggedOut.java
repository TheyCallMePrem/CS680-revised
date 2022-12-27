package edu.umb.cs680.hw10.fs.util;

public class LoggedOut implements State{
    private static SecureContext ctx;
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
    public static void setSecureContext(SecureContext ctx) {
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
    public static boolean authenticate(SecureContext ctx, EncryptedString password){

        System.out.println("Invoked authenticator");
        return true;
    }
}