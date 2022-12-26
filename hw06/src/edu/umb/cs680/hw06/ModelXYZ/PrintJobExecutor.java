package edu.umb.cs680.hw06.ModelXYZ;
import edu.umb.cs680.hw06.PrintingFramework.*;

public class PrintJobExecutor extends edu.umb.cs680.hw06.PrintingFramework.PrintJobExecutor{
    
    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx){
        System.out.println("===== This model: XYZ does not support authentication =====");
    }

    @Override
    protected  void doAccessControl(){
        System.out.println("doAccessControl() invoked, nothing here");
    }

    @Override
    protected  void doPrint() throws Exception{
        System.out.println("doPrint() invoked, actual printing logic is in this method");
    }

    @Override
    protected  void doErrorHandling(){
        System.out.println("doErrorHandling() invoked, actual printing related errors are handled here");
    }

    public static void main (String args[]){

        PrintJobExecutor PJ_modelXYZ= new PrintJobExecutor();
        EncryptedString ES = new EncryptedString("password");
        SecurityContext SC = new SecurityContext();

    
            try {
                PJ_modelXYZ.execute(null, ES, SC);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        
        
    }
}
