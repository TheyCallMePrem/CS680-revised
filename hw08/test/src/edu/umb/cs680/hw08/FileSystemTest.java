package edu.umb.cs680.hw08;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class FileSystemTest {
    private static FileSystem fs ;
    // @BeforeAll
    // public static void setupFS(){
    //     testFixtureInitializer TFS = new testFixtureInitializer();
    //     fs= TFS.createFS();
    // }

    @Test 
    public void FileSystemIsSingeltonClass(){
        FileSystem f1= FileSystem.getFileSystem();
        FileSystem f2 = FileSystem.getFileSystem();
        assertSame(f1,f2);
    }

    @Test
    public void getRootDirsReturnsInstanceOfDirectoryClass(){
        fs= testFixtureInitializer.createFS();
        assertTrue(fs.getRootDirs() instanceof Directory); 
    }

    @Test
    public void getRootDirsReturnsRoot(){
        fs= testFixtureInitializer.createFS();
        assertEquals(fs.getRootDirs().getName(),"root"); 
    }

}