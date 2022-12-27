package edu.umb.cs680.hw09;
import edu.umb.cs680.hw09.fs.FileSystem;
import edu.umb.cs680.hw09.fs.util.CountingVisitor;
import edu.umb.cs680.hw09.fs.util.FileCrawlingVisitor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
public class FileSystemTest {
    FileSystem fs = TestFixtureInitializer.createFS();

    @Test
    public void verifyCountingVisitorGetFilenum(){
        CountingVisitor cv =new CountingVisitor();
        cv.visit(fs.getRootDirs());
        assertEquals(1, cv.getfileNum()); 
    }

    @Test
    public void verifyCountingVisitorGetLinkNum(){
        CountingVisitor cv =new CountingVisitor();
        cv.visit(fs.getRootDirs());
        assertEquals(0, cv.getlinkNum()); 
    }

    @Test
    public void verifyFileCrawilingVisitor(){
        FileCrawlingVisitor fcv = new FileCrawlingVisitor();
        fcv.visit(fs.getRootDirs());
        
        fcv.visit(fs.getRootDirs().getSubDirectories().getLast().getFiles().getLast());
        assertEquals("x", fcv.getFiles().getLast().getName()); 
    }

    @Test
    public void verifyFileSearchVisitor(){
        FileCrawlingVisitor fcv = new FileCrawlingVisitor();
        fcv.visit(fs.getRootDirs());
        
        fcv.visit(fs.getRootDirs().getSubDirectories().getLast().getFiles().getLast());
        assertEquals("x", fcv.getFiles().getLast().getName()); 
    }
}
