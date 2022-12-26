package edu.umb.cs680.hw06.PrintingFramework;





public abstract class PrintJobExecutor{

    //Final method, which contains the method execution template 
    public final void execute(PrintJob job, EncryptedString pwd, SecurityContext ctx)  throws Throwable{
        doAuthentication(pwd,  ctx);
        doAccessControl();
        doPrint();
        doErrorHandling();
    }

    
    protected abstract void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception;
    
    protected abstract void doAccessControl();
    
    protected abstract void doPrint() throws Exception;
    
    protected abstract void doErrorHandling();
}