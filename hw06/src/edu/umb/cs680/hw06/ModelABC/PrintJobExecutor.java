package edu.umb.cs680.hw06.ModelABC;
import edu.umb.cs680.hw06.PrintingFramework.*;
public class PrintJobExecutor extends edu.umb.cs680.hw06.PrintingFramework.PrintJobExecutor{
    String loginStatus="";
    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception{
        System.out.println("doAuthentication( pwd: EncryptedString, ctx: SecurityContext ) invoked");
        System.out.println("\t ===== This model:ABC Supports authentication =====");
        System.out.println("\t Authenticator invoked" );
        try {
			State LI = new LoggedIn();
            ctx.changeState(LI);
            loginStatus= ctx.getState().getClass().toString().substring(43);
            System.out.println("\t The current state is: " + loginStatus ); 
		}
		catch(NullPointerException e) {
			System.out.println("Login failed, print job terminated");
		}
        
        

    }

    @Override
    protected  void doAccessControl(){
        System.out.println("\n doAccessControl() invoked");
    }

    @Override
    protected  void doPrint() throws Exception{
        System.out.println("\n doPrint() invoked");
        if( loginStatus.equals("LoggedIn" )){
            System.out.println("Login detected, printing will begin");
            System.out.println("Printing logic....");
        }
        else{
            System.out.println("Login failed, printing operation terminated");
            throw new Exception("Login failed, print job terminated");
        }
       
    }

    @Override
    protected  void doErrorHandling(){
        System.out.println("\n doErrorHandling() invoked");
    }

    public static void main (String args[]){

        PrintJobExecutor PJ_modelABC= new PrintJobExecutor();
        EncryptedString ES = new EncryptedString("password");
        SecurityContext SC = new SecurityContext();
        System.out.println("\n The frist example has valid login credentials and printing will be done succesfully \n");
        try {
            PJ_modelABC.execute(null, ES, SC);
        } 
        catch (Throwable e) {
            System.out.println("Caught in main");
        }

        System.out.println("\n The Second example has invalid login credentials and printing will not be done \n");
        // When SecurityContext is NULL , it should terminte the print job
        try {
            
            PJ_modelABC.execute(null, null, null);
        } 
        catch (Throwable e) {
            e.printStackTrace();
            System.out.println("Login failed, print job terminated");
        }
        
            
        
    }
}



    
    
