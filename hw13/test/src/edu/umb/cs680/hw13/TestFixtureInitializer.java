package edu.umb.cs680.hw13;




import java.time.LocalDateTime;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.File;
import edu.umb.cs680.hw13.fs.FileSystem;


public class TestFixtureInitializer {
    public static FileSystem createFS(){
        Directory root = new Directory(null, "root",0, LocalDateTime.now() );

        //Sub directories of root directory
        Directory home = new Directory(root, "home" , 0 , LocalDateTime.now());
        Directory bin = new Directory(root, "lib", 0 , LocalDateTime.now());
        Directory Apps = new Directory(root, "Apps", 0 , LocalDateTime.now());

        //Children of Apps directory
        File x = new File(Apps, "x" , 7 , LocalDateTime.now());

        // Children of bin directory
        File y = new File(bin, "y", 6 , LocalDateTime.now());

        // Children of home directory
        Directory pictures = new Directory(home, "pictures", 0 , LocalDateTime.now());
        File c = new File(home, "c" , 1 , LocalDateTime.now());
        
        // Children of pictures directory
        File a = new File(pictures, "a" , 3 , LocalDateTime.now());
        File b = new File(pictures, "b" , 2 , LocalDateTime.now());

        //Creating proxies 
        root.appendChild(home);
        root.appendChild(bin);
        root.appendChild(Apps);

        Apps.appendChild(x);

        bin.appendChild(y);

        home.appendChild(pictures);
        home.appendChild(c);

        pictures.appendChild(a);
        pictures.appendChild(b);

        FileSystem homework13 = FileSystem.getFileSystem(); 
        homework13.appendRootDir(root);
        return homework13;
    }
}
