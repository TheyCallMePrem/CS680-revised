package edu.umb.cs680.hw06.PrintingFramework;

public class LoggedIn implements State{
    private static SecurityContext ctx;
    private static LoggedIn LIobject=null;
    @Override
    public void login(EncryptedString pwd){
        System.out.println("login() of state LoggedIn");
        if(ctx.isActive()){
            ctx.changeState(LoggedOut.getInstance());
            ctx.login(pwd);
        }
    }

    @Override
    public void logout(){
        System.out.println("logout() of state LoggedIn");
        ctx.changeState( LoggedOut.getInstance() );
    }

    public static void setSecurityContext(SecurityContext ctx) {
		LoggedIn.ctx = ctx;
	}   

     public LoggedIn( ){
    }

    public static LoggedIn getInstance(){
        // create object if it's not already created --- sINGLETON
        System.out.println("reached");
        if(LIobject == null){
            System.out.println("reached2");
            // LIobject = new LoggedIn(ctx);
            // LoggedIn.CreateInstance(ctx);
            LIobject = new LoggedIn();
        }
        return LIobject;
    }
}