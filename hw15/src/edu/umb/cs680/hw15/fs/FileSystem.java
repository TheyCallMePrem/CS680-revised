package edu.umb.cs680.hw15.fs;


import java.time.LocalDateTime;
import java.util.LinkedList;

import edu.umb.cs680.hw15.fs.util.CountingVisitor;
import edu.umb.cs680.hw15.fs.util.FileCrawlingVisitor;
import edu.umb.cs680.hw15.fs.util.FileSearchVisitor;





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
        // System.out.println(homework8.getRootDirs());
        // System.out.println(root.getChildren());
        //Creating proxies 
        
        
        
        
        //Running proxy methods
        CountingVisitor cv =new CountingVisitor();
        FileCrawlingVisitor fcv = new FileCrawlingVisitor();
        FileSearchVisitor fsv = new FileSearchVisitor();

        fsv.visit(root);
        fcv.visit(root);
        root.accept(cv);

        fsv.visit(pictures);
        fsv.visit(a);
        fsv.visit(x);
        fcv.visit(b);

        LinkedList<FSElement> outputAlphabeticalComparator = new LinkedList<FSElement>();
        outputAlphabeticalComparator = root.getChildren((FSElement fse1, FSElement fse2)->fse1.getName().compareTo(fse2.getName()));
        System.out.println("outputAlphabeticalComparator:"  );
        
        for(FSElement fse : outputAlphabeticalComparator){
            System.out.print(fse.getName() + " ");
        }

        LinkedList<FSElement> outputReverseAlphabeticalComparator = new LinkedList<FSElement>();
        outputReverseAlphabeticalComparator = root.getChildren((FSElement fse1, FSElement fse2)->fse2.getName().compareTo(fse1.getName()));
        System.out.println("\noutputReverseAlphabeticalComparator:"  );
        
        for(FSElement fse : outputReverseAlphabeticalComparator){
            System.out.print(fse.getName() + " ");
        }

        LinkedList<FSElement> outputSizeComparator = new LinkedList<FSElement>();
        outputSizeComparator = root.getChildren((FSElement fse1, FSElement fse2)-> (int)(fse1.getSize() - fse2.getSize()));
        System.out.println("\noutputSizeComparator:"  );
        
        for(FSElement fse : outputSizeComparator){
            System.out.print(fse.getName() + " ");
        }

        LinkedList<FSElement> outputTimeStampComparator = new LinkedList<FSElement>();
        outputTimeStampComparator = root.getChildren((FSElement fse1, FSElement fse2) -> (int)((fse1.getCreationtime()).compareTo(fse2.getCreationtime())));
        System.out.println("\noutputTimeStampComparator:"  );
        
        for(FSElement fse : outputTimeStampComparator){
            System.out.print(fse.getName() + " ");
        }
        
    }
}

// AlphabeticalComparator
    // (FSElement fse1, FSElement fse2)->fse1.getName().compareTo(fse2.getName())

// ReverseAlphabeticalComparator
    // (FSElement fse1, FSElement fse2)->fse2.getName().compareTo(fse1.getName())

//SizeComparator 
    // (FSElement fse1, FSElement fse2)-> {(int)(fse1.getSize() - fse2.getSize())}

// TimeStampComparator 
    // (FSElement fse1, FSElement fse2) -> {(int) ((fse1.getCreationtime()).compareTo(fse2.getCreationtime()))}