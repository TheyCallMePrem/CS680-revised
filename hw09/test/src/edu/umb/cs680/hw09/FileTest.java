package edu.umb.cs680.hw09;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import edu.umb.cs680.hw09.fs.FileSystem;

public class FileTest {
    private static FileSystem fs ;
    @BeforeAll
    public static void setupFS(){
        fs= TestFixtureInitializer.createFS();
    }

    @Test
    public void FilesystemIsNotnull(){
        setupFS();
        assertNotNull(fs);
    }

    @Test
    public void isDirectoryReturnsFalse(){
        setupFS();
        assertFalse(fs.getRootDirs().getSubDirectories().getFirst().getFiles().getFirst().isDirectory());
    }
}
