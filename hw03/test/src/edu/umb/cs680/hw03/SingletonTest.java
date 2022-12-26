package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// import edu.umb.cs680.hw03.Singleton;



public class SingletonTest{

    @Test
    public void GetInstanceReturnsNonNullValue() {
        assertNotNull(Singleton.getInstance());
    }

    @Test
    public void GetInstanceReturnsIdenticalInstanceOnMultiplecCall() {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        assertSame(s1,s2);
    }

    @Test
    public void SameHashCodeForDifferentInstances() {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        assertEquals(s1.hashCode(),s2.hashCode());
    }

}
