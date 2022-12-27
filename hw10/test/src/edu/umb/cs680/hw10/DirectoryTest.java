package edu.umb.cs680.hw10;
import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class DirectoryTest {
    FileSystem fs = TestFixtureInitializer.createFS();
    private String[] dirToStringArray(Directory d) {
		String[] dirInfo = 
        { 
            String.valueOf(d.isDirectory()),  
            String.valueOf(d.getTotalSize()),
            String.valueOf(d.countChildren()) 
        };
		return dirInfo;
	}

    @Test
	public void rootReturnsCorrectly() {
        
		String[] expected = { "true",  "19",  "5" };
		Directory actual = fs.getRootDirs();
		assertArrayEquals(expected, dirToStringArray(actual));
	}

    @Test
    public void FilesystemIsNotnull(){
          
        assertNotNull(fs);
    }

    @Test
    public void rootIsNotnull(){
         
        assertNotNull(fs.getRootDirs());
    }

    @Test
    public void ReturnsCorrectnumberOfChildrenForRootDirectory(){
         
        assertEquals(fs.getRootDirs().countChildren(), 5);
    }

    @Test
    public void ReturnsNotNullLinkedListObjectOfSubDirectoriesForRootDirectory(){
         
        assertNotNull(fs.getRootDirs().getSubDirectories());
    }

    @Test
    public void ReturnsNotNullLinkedListObjectOfFilesForRootDirectory(){
         
        assertNotNull(fs.getRootDirs().getFiles());
    }

    @Test
    public void ReturnsNullforRootDirectorysParent(){
         
        assertNull(fs.getRootDirs().getParentDirectory());
    }
    @Test
    public void ReturnsNotNullforSubDirectorysParent(){
         
        assertNotNull(fs.getRootDirs().getChildren().getFirst().getparentDirectory()); 
    }
    //fs.getRootDirs() gives root directory, .getChildren() returns LinkedList of children, getFirst() extracts first element of 
    // that LinkedList and finallly .getparentDirectory() return's the extracted child's parent directory (i.e. root)
    

    @Test
    public void ReturnsNullforRootsChildFiles(){
         
        LinkedList<File> Filelist = new LinkedList<File>(); //Empty LinkedList for holding File elements
        assertEquals(Filelist,fs.getRootDirs().getFiles()); //Root should have no files so it should equal to Filelist variable
    }

    @Test
    public void ReturnsCorrectDirectoryName(){
         
        assertEquals(fs.getRootDirs().getName(),"root");
    }

    @Test
    public void ReturnsCorrectDirectorySize(){
         
        assertEquals(fs.getRootDirs().getTotalSize(),19);
    }
    
    
    @Test
    public void GetCreationtimeReturnsInstanceOfDateTimeClass(){
         
        assertTrue(fs.getRootDirs().getCreationtime() instanceof LocalDateTime); 
    }
}
