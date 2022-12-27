package edu.umb.cs680.hw09;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import edu.umb.cs680.hw09.fs.FileSystem;

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
