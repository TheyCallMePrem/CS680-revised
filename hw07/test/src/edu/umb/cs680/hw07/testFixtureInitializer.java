package edu.umb.cs680.hw07;
import java.time.LocalDateTime;
import edu.umb.cs680.hw07.File;
import edu.umb.cs680.hw07.FileSystem;
import edu.umb.cs680.hw07.FSElement;
import edu.umb.cs680.hw07.Directory;

import  edu.umb.cs680.hw07.*;
public  class testFixtureInitializer {
    public static FileSystem createFS(){
        Directory root = new Directory(null, "root",0, LocalDateTime.now() );
        // Children of root directory
        Directory home = new Directory(root, "home" , 0 , LocalDateTime.now());
        Directory lib = new Directory(root, "lib", 0 , LocalDateTime.now());
        Directory Apps = new Directory(root, "Apps", 0 , LocalDateTime.now());
        //Child of home directory
        Directory code = new Directory(home, "code", 0 , LocalDateTime.now());

        // NOTE: Directories will have 0 file size at the tie of creation, but getTotalSize() 
        // will fetch the size of directory once we nest files in it


        //Files of Apps directory
        File x = new File(Apps, "x" , 7 , LocalDateTime.now());
        File y = new File(Apps, "y", 6 , LocalDateTime.now());

        //Files of lib directory
        File z = new File(lib, "z", 5 , LocalDateTime.now());

        //Files of home directory
        File d = new File(home, "d" , 4 , LocalDateTime.now());

        //Files of code directory
        File a = new File(code, "a" , 3 , LocalDateTime.now());
        File b = new File(code, "b" , 2 , LocalDateTime.now());
        File c = new File(code, "c" , 1 , LocalDateTime.now());

        root.appendChild(home);
        root.appendChild(lib);
        root.appendChild(Apps);

        Apps.appendChild(x);
        Apps.appendChild(y);

        lib.appendChild(z);

        home.appendChild(code);
        home.appendChild(d);

        code.appendChild(a);
        code.appendChild(b);
        code.appendChild(c);

        FileSystem fs = FileSystem.getFileSystem();
        fs.appendRootDir(root);
        return fs;
    }
}