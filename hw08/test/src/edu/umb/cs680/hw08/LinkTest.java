package edu.umb.cs680.hw08;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;



public class LinkTest {
    private static FileSystem fs ;
    @BeforeAll
    public static void setupFS(){
        
        fs= testFixtureInitializer.createFS();
    }
    
    @Test
    public void ReturnsFalseForIsDirectory() {
        fs= testFixtureInitializer.createFS();
        assertFalse(fs.getRootDirs().getChildren().getLast().isDirectory());
    }

    @Test
    public void ReturnsNameCorrectly() {
        fs= testFixtureInitializer.createFS();
        assertEquals(fs.getRootDirs().getChildren().getLast().getName(),"e");
    }

    @Test
    public void ReturnsTargetCorrectly() {
        fs= testFixtureInitializer.createFS();
        assertEquals(fs.getRootDirs().getProxies().getFirst().getTarget().getName(),"pictures");
    }

}
