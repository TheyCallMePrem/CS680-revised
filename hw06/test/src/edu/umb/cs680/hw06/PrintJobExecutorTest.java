package edu.umb.cs680.hw06;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw06.ModelABC.*;
import edu.umb.cs680.hw06.ModelXYZ.*;
public class PrintJobExecutorTest{
    
    
    //Instance of new model XYZ
    edu.umb.cs680.hw06.ModelXYZ.PrintJobExecutor PJ_modelXYZ= new edu.umb.cs680.hw06.ModelXYZ.PrintJobExecutor();
    
    //Instance of new model ABC
    edu.umb.cs680.hw06.ModelABC.PrintJobExecutor PJ_modelABC= new edu.umb.cs680.hw06.ModelABC.PrintJobExecutor();
    
   
    

    //Tests for XYZ
    @Test
    public void InstanceOfModelXYZIsNotNull() {
        assertNotNull(PJ_modelXYZ);
	}

    @Test
    public void XYZExecutesTheTemplateWithoutAnyErrorOrException() {
        try {
            PJ_modelXYZ.execute(null, null, null);
        } 
        catch (Throwable e) {
            assertEquals("Login failed, print job terminated",
                e.getMessage() );
        }
	}

    //Tests for ABC
    @Test
    public void InstanceOfModelABCIsNotNull() {
        assertNotNull(PJ_modelABC);
	}

    @Test
    public void ABCExecutesTheTemplateWithoutAnyErrorOrException() {
        try {
            PJ_modelABC.execute(null, null, null);
        } 
        catch (Throwable e) {
            assertEquals("Login failed, print job terminated",
                e.getMessage() );
        }
	}

    @Test
    public void ABCThrowsExceptionOnInvalidLogin() throws Throwable {
        try {
                PJ_modelABC.execute(null, null, null);
        } 
        catch (Exception e) {
                assertEquals("Login failed, print job terminated",
                e.getMessage() );
            }
    }
}
