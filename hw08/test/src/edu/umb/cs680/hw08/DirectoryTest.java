package edu.umb.cs680.hw08;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.Test;


public class DirectoryTest {
    
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
    public void rootIsNotnull(){
        fs= testFixtureInitializer.createFS();
        assertNotNull(fs.getRootDirs());
    }

    @Test
    public void ReturnsCorrectnumberOfChildrenForRootDirectory(){
        fs= testFixtureInitializer.createFS();
        assertEquals(fs.getRootDirs().countChildren(), 5);
    }

    @Test
    public void ReturnsNotNullLinkedListObjectOfSubDirectoriesForRootDirectory(){
        fs= testFixtureInitializer.createFS();
        assertNotNull(fs.getRootDirs().getSubDirectories());
    }

    @Test
    public void ReturnsNotNullLinkedListObjectOfFilesForRootDirectory(){
        fs= testFixtureInitializer.createFS();
        assertNotNull(fs.getRootDirs().getFiles());
    }

    @Test
    public void ReturnsNullforRootDirectorysParent(){
        fs= testFixtureInitializer.createFS();
        assertNull(fs.getRootDirs().getParentDirectory());
    }
    @Test
    public void ReturnsNotNullforSubDirectorysParent(){
        fs= testFixtureInitializer.createFS();
        assertNotNull(fs.getRootDirs().getChildren().getFirst().getparentDirectory()); 
    }
    //fs.getRootDirs() gives root directory, .getChildren() returns LinkedList of children, getFirst() extracts first element of 
    // that LinkedList and finallly .getparentDirectory() return's the extracted child's parent directory (i.e. root)
    

    @Test
    public void ReturnsNullforRootsChildFiles(){
        fs= testFixtureInitializer.createFS();
        LinkedList<File> Filelist = new LinkedList<File>(); //Empty LinkedList for holding File elements
        assertEquals(Filelist,fs.getRootDirs().getFiles()); //Root should have no files so it should equal to Filelist variable
    }

    @Test
    public void ReturnsCorrectDirectoryName(){
        fs= testFixtureInitializer.createFS();
        assertEquals(fs.getRootDirs().getName(),"root");
    }

    @Test
    public void ReturnsCorrectDirectorySize(){
        fs= testFixtureInitializer.createFS();
        assertEquals(fs.getRootDirs().getTotalSize(),19);
    }
    
    
    @Test
    public void GetCreationtimeReturnsInstanceOfDateTimeClass(){
        fs= testFixtureInitializer.createFS();
        assertTrue(fs.getRootDirs().getCreationtime() instanceof LocalDateTime); 
    }
}
