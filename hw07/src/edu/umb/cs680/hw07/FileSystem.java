package edu.umb.cs680.hw07;
import java.time.LocalDateTime;


public class FileSystem {
	private static FileSystem instance = null;
	private Directory rootDir;
     
	
    private FileSystem(){}
	public static FileSystem getFileSystem() {
		if (instance == null) {
			instance = new FileSystem();
		}
        
		return instance;
	}
	
	public Directory getRootDirs(){
		return rootDir;
	}
	
	public void appendRootDir(Directory root) {
		this.rootDir = root;
	}

    
    public static void main(String[] args) {
        

        //Root directory
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

        FileSystem homework7 = new FileSystem(); 
        homework7.appendRootDir(root);

        //Running FileSystem'S methods
        System.out.println(homework7.getRootDirs());


        //Running root directory's methods
        System.out.println("=========root directory=========");
        System.out.println("Children = " + root.getChildren());
        System.out.println("number of children " + root.countChildren());
        System.out.println("Total Size: " + root.getTotalSize());
        System.out.println("Files in this directory: " + root.getFiles());
        System.out.println("Sub Directories in this directory: " + root.getSubDirectories());
        System.out.println("Parent Directory: " + root.getParentDirectory());
        System.out.println("isDirectory(): " + root.isDirectory());
        System.out.println("created: " + root.getCreationtime());
        System.out.println("Name: " + root.getName());

         //Running home directory's methods
         System.out.println("=========home directory=========");
         System.out.println("Children = " + home.getChildren());
         System.out.println("number of children " + home.countChildren());
         System.out.println("Total Size: " + home.getTotalSize());
         System.out.println("Files in this directory: " + home.getFiles());
         System.out.println("Sub Directories in this directory: " + home.getSubDirectories());
         System.out.println("Parent Directory: " + home.getParentDirectory());
         System.out.println("isDirectory(): " + home.isDirectory());
         System.out.println("created: " + home.getCreationtime());
         System.out.println("Name: " + home.getName());

         //Running lib directory's methods
         System.out.println("=========lib directory=========");
         System.out.println("Children = " + lib.getChildren());
         System.out.println("number of children " + lib.countChildren());
         System.out.println("Total Size: " + lib.getTotalSize());
         System.out.println("Files in this directory: " + lib.getFiles());
         System.out.println("Sub Directories in this directory: " + lib.getSubDirectories());
         System.out.println("Parent Directory: " + lib.getParentDirectory());
         System.out.println("isDirectory(): " + lib.isDirectory());
         System.out.println("created: " + lib.getCreationtime());
         System.out.println("Name: " + lib.getName());

         //Running Apps directory's methods
         System.out.println("=========lib directory=========");
         System.out.println("Children = " + Apps.getChildren());
         System.out.println("number of children " + Apps.countChildren());
         System.out.println("Total Size: " + Apps.getTotalSize());
         System.out.println("Files in this directory: " + Apps.getFiles());
         System.out.println("Sub Directories in this directory: " + Apps.getSubDirectories());
         System.out.println("Parent Directory: " + Apps.getParentDirectory());
         System.out.println("isDirectory(): " + Apps.isDirectory());
         System.out.println("created: " + Apps.getCreationtime());
         System.out.println("Name: " + Apps.getName());

         //Running code directory's methods
         System.out.println("=========code directory=========");
         System.out.println("Children = " + code.getChildren());
         System.out.println("number of children " + code.countChildren());
         System.out.println("Total Size: " + code.getTotalSize());
         System.out.println("Files in this directory: " + code.getFiles());
         System.out.println("Sub Directories in this directory: " + code.getSubDirectories());
         System.out.println("Parent Directory: " + code.getParentDirectory());
         System.out.println("isDirectory(): " + code.isDirectory());
         System.out.println("created: " + code.getCreationtime());
         System.out.println("Name: " + code.getName());

         //Running file x's methods
         System.out.println("=========File x=========");
         System.out.println("getName() " + x.getName());
         System.out.println("getSize() " + x.getSize());
         System.out.println("getCreationtime() : " + x.getCreationtime());
         System.out.println("getparentDirectory() : " + x.getparentDirectory());

         //Running file a's methods
         System.out.println("=========File x=========");
         System.out.println("getName() " + a.getName());
         System.out.println("getSize() " + a.getSize());
         System.out.println("getCreationtime() : " + a.getCreationtime());
         System.out.println("getparentDirectory() : " + a.getparentDirectory());

         //Running file d's methods
         System.out.println("=========File x=========");
         System.out.println("getName() " + d.getName());
         System.out.println("getSize() " + d.getSize());
         System.out.println("getCreationtime() : " + d.getCreationtime());
         System.out.println("getparentDirectory() : " + d.getparentDirectory());
    }
}