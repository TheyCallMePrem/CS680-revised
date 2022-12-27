

package edu.umb.cs680.hw10.fs.util;

public class SecureContext {
    private State currentState;
    public SecureContext(){
        this.currentState=LoggedOut.getInstance();
    }
    public void changeState(State newState){
        this.currentState=newState;
    }
    public void login(EncryptedString pwd){
        System.out.println("login() of SecureContext");
        currentState.login(pwd);
    }

    public void logout(){
        System.out.println("logout() of SecureContext");
        currentState.logout();
    }

    public State getState(){
        //Returning current state of the security context
        return this.currentState;
    }

    public boolean isActive(){
        return true;
    }
    public static SecureContext getInstance(SecureContext ctx) {
		if (ctx == null) 
        {
			ctx = new SecureContext();
			ctx.changeState(new LoggedOut());
		}
		return ctx;
	}

    public static void main(String args[]){
        SecureContext SC = new SecureContext();
        System.out.println("Created new instance of SecureContextClass , with initial state : ");
        System.out.println(SC.getState());
        System.out.println("The State belongs to the class : ");
        System.out.println((SC.getState()).getClass());
        
        SecureContext.getInstance(SC);
        System.out.println("The instance of class is : ");
        System.out.println(SecureContext.getInstance(SC));
        
        State LI = new LoggedIn();
        SC.changeState(LI);
        System.out.println("After logging in : ");
        System.out.println(SC.getState());
        System.out.println("Class of this state is:");
        System.out.println((SC.getState()).getClass());
    }
}