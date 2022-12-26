

package edu.umb.cs680.hw05;

public class SecurityContext {
    private State currentState;
    private static SecurityContext ctx = null;
    public SecurityContext(){
        this.currentState=LoggedOut.getInstance();
    }
    public void changeState(State newState){
        this.currentState=newState;
    }
    public void login(EncryptedString pwd){
        System.out.println("login() of SecurityContext");
        currentState.login(pwd);
    }

    public void logout(){
        System.out.println("logout() of SecurityContext");
        currentState.logout();
    }

    public State getState(){
        //Returning current state of the security context
        return this.currentState;
    }

    public boolean isActive(){
        return true;
    }
    public static SecurityContext getInstance(SecurityContext ctx) {
		if (ctx == null) 
        {
			ctx = new SecurityContext();
			ctx.changeState(new LoggedOut());
		}
		return ctx;
	}

    public static void main(String args[]){
        SecurityContext SC = new SecurityContext();
        System.out.println("Created new instance of SecurityContextClass , with initial state : ");
        System.out.println(SC.getState());
        System.out.println("The State belongs to the class : ");
        System.out.println((SC.getState()).getClass());
        EncryptedString ES = new EncryptedString("testPassword");
        
        SecurityContext.getInstance(SC);
        System.out.println("The instance of class is : ");
        System.out.println(SecurityContext.getInstance(SC));
        
        State LI = new LoggedIn();
        SC.changeState(LI);
        System.out.println("After logging in : ");
        System.out.println(SC.getState());
        System.out.println("Class of this state is:");
        System.out.println((SC.getState()).getClass());
    }
}