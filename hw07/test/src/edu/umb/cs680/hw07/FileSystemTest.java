package edu.umb.cs680.hw07;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;


public class FileSystemTest {
    private static FileSystem fs ;
    @BeforeAll
    public static void setupFS(){
        testFixtureInitializer TFS = new testFixtureInitializer();
        fs= TFS.createFS();
    }

    @Test 
    public void FileSystemIsSingeltonClass(){
        edu.umb.cs680.hw07.FileSystem f1= edu.umb.cs680.hw07.FileSystem.getFileSystem();
        edu.umb.cs680.hw07.FileSystem f2 = edu.umb.cs680.hw07.FileSystem.getFileSystem();
        assertSame(f1,f2);
    }

    @Test
    public void getRootDirsReturnsInstanceOfDirectoryClass(){
        setupFS();
        assertTrue(fs.getRootDirs() instanceof Directory); 
    }

    @Test
    public void getRootDirsReturnsRoot(){
        setupFS();
        assertEquals(fs.getRootDirs().getName(),"root"); 
    }

}