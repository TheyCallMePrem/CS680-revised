package edu.umb.cs680.hw10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import edu.umb.cs680.hw10.fs.*;

public class LinkTest {
    private static FileSystem fs ;
    @BeforeAll
    public static void setupFS(){
        fs= TestFixtureInitializer.createFS();
    }
    
    @Test
    public void ReturnsNameCorrectly() {
        setupFS();
        assertEquals(fs.getRootDirs().getChildren().getLast().getName(),"e");
    }

    @Test
    public void ReturnsTargetCorrectly() {
        setupFS();
        assertEquals(fs.getRootDirs().getProxies().getFirst().getTarget().getName(),"pictures");
    }
}