package edu.umb.cs680.hw08;

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
        
        //root directory
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

        Link d = new Link(root,"d",4, LocalDateTime.now(),pictures);
        Link e = new Link(root,"e",5, LocalDateTime.now(),x);

        
        

        root.appendChild(home);
        root.appendChild(bin);
        root.appendChild(Apps);
        root.appendChild(d);
        root.appendChild(e);
        Apps.appendChild(x);

        bin.appendChild(y);

        home.appendChild(pictures);
        home.appendChild(c);

        pictures.appendChild(a);
        pictures.appendChild(b);

        FileSystem homework8 = new FileSystem(); 
        homework8.appendRootDir(root);

        //Running FileSystem'S methods
        System.out.println(homework8.getRootDirs());
        System.out.println(root.getChildren());
        //Creating proxies 
        
        
        
        
        //Running proxy methods
        System.out.println("Running proxy d's methods");
        System.out.println(d.getName());
        System.out.println(d.getSize());
        System.out.println(d.getTarget().getName());
        System.out.println(d.getSize());
        
        //Running proxy methods
        System.out.println("Running proxy e's methods");
        System.out.println(e.getName());
        System.out.println(e.getSize());
        System.out.println(e.getTarget().getName());
        
    }
}
