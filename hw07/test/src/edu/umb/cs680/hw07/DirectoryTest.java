package edu.umb.cs680.hw07;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.LinkedList;


import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class DirectoryTest {
    
    private static FileSystem fs ;
    @BeforeAll
    public static void setupFS(){
        testFixtureInitializer TFS = new testFixtureInitializer();
        fs= TFS.createFS();
    }

    @Test
    public void FilesystemIsNotnull(){
        // setupFS();
        assertNotNull(fs);
    }

    @Test
    public void rootIsNotnull(){
        setupFS();
        assertNotNull(fs.getRootDirs());
    }

    @Test
    public void ReturnsCorrectnumberOfChildrenForRootDirectory(){
        setupFS();
        assertEquals(fs.getRootDirs().countChildren(), 3);
    }

    @Test
    public void ReturnsNotNullLinkedListObjectOfSubDirectoriesForRootDirectory(){
        setupFS();
        assertNotNull(fs.getRootDirs().getSubDirectories());
    }

    @Test
    public void ReturnsNotNullLinkedListObjectOfFilesForRootDirectory(){
        setupFS();
        assertNotNull(fs.getRootDirs().getFiles());
    }

    @Test
    public void ReturnsNullforRootDirectorysParent(){
        setupFS();
        assertNull(fs.getRootDirs().getParentDirectory());
    }
    @Test
    public void ReturnsNotNullforSubDirectorysParent(){
        setupFS();
        assertNotNull(fs.getRootDirs().getChildren().getFirst().getparentDirectory()); 
    }
    //fs.getRootDirs() gives root directory, .getChildren() returns LinkedList of children, getFirst() extracts first element of 
    // that LinkedList and finallly .getparentDirectory() return's the extracted child's parent directory (i.e. root)
    

    @Test
    public void ReturnsNullforRootsChildFiles(){
        setupFS();
        LinkedList<File> Filelist = new LinkedList<File>(); //Empty LinkedList for holding File elements
        assertEquals(Filelist,fs.getRootDirs().getFiles()); //Root should have no files so it should equal to Filelist variable
    }

    @Test
    public void ReturnsCorrectDirectoryName(){
        setupFS();
        assertEquals(fs.getRootDirs().getName(),"root");
    }

    @Test
    public void ReturnsCorrectDirectorySize(){
        setupFS();
        assertEquals(fs.getRootDirs().getTotalSize(),28);
    }
    
    
    @Test
    public void GetCreationtimeReturnsInstanceOfDateTimeClass(){
        setupFS();
        assertTrue(fs.getRootDirs().getCreationtime() instanceof LocalDateTime); 
    }
}
