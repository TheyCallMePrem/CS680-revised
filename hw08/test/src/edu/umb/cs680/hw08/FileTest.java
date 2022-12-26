package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.Test;

public class FileTest {
    private static FileSystem fs ;
    // @BeforeAll
    // public static void setupFS(){
    //     testFixtureInitializer TFS = new testFixtureInitializer();
    //     fs= TFS.createFS();
    // }

    @Test
    public void FilesystemIsNotnull(){
        fs= testFixtureInitializer.createFS();
        assertNotNull(fs);
    }

    @Test
    public void isDirectoryReturnsFalse(){
        fs= testFixtureInitializer.createFS();
        assertFalse(fs.getRootDirs().getSubDirectories().getFirst().getFiles().getFirst().isDirectory());
    }
    // I have used nested methods to invoke .isDirectory() function of File "x" of the fixture. 
    // fs.getRootDirs() gives root directory of fixture
    // fs.getRootDirs().getSubDirectories() gives Linked list of sub directories of root => Apps, lib, home
    // fs.getRootDirs().getSubDirectories().getFirst() gives first element => Apps
    // fs.getRootDirs().getSubDirectories().getFirst().getFiles() gives Linked list of subfiles nested  in Apps directory => X -> Y
    // fs.getRootDirs().getSubDirectories().getFirst().getFiles().getFirst().isDirectory() extracts first element from list of files and runs it's isDirectory() method
}
