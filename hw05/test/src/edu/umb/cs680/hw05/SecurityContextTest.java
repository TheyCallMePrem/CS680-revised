package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SecurityContextTest {
	SecurityContext SC = new SecurityContext();
	@Test
    public void NewlyDeclaredInstanceOfSecurityClassIsNotNull() {
        SecurityContext SC = new SecurityContext();
        assertNotNull(SecurityContext.getInstance(SC));
	}

    @Test
    public void NewlyDeclaredInstanceOfSecurityClassDoesNotHaveNullState(){
        SecurityContext SC = new SecurityContext();
        assertNotNull(SC.getState());
    }
     
    @Test
    public void NewlyDeclaredInstanceOfSecurityClassHasLoggedOutState() {
	SecurityContext SC = new SecurityContext();
    LoggedOut LO = new LoggedOut();
	assertEquals((SC.getState()).getClass(), LO.getClass());
	}


    @Test
    public void MultipleInstancesOfNewlyCreatedSecurityContextHasSameClass() {
	SecurityContext SC1 = new SecurityContext();
    SecurityContext SC2 = new SecurityContext();
	assertEquals(SecurityContext.getInstance(SC1).getClass(), SecurityContext.getInstance(SC2).getClass());
	}

    @Test
    public void CanLoginWhileLoggedOut() {
	SecurityContext SC = new SecurityContext();
    SC.changeState(new LoggedIn());
    LoggedIn LI = new LoggedIn();
    assertEquals((SC.getState()).getClass(), LI.getClass());
	}

    @Test
    public void CanLogOutWhileLoggedIn() {
	SecurityContext SC = new SecurityContext();
    SC.changeState(new LoggedIn());
    SC.changeState(new LoggedOut());
    assertEquals((SC.getState()).getClass(), (new LoggedOut()).getClass());
	}
}
    
