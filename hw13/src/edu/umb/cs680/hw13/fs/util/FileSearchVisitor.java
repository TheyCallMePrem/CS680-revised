package edu.umb.cs680.hw13.fs.util;


import java.util.LinkedList;

import edu.umb.cs680.hw13.fs.*;

public class FileSearchVisitor implements FSVisitor{
    // Perform virus check for each file in a file system
    private String fileName;
	private LinkedList<File> foundFiles;
    
    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(Directory dir) {
        return;
    }

    @Override
    public void visit(File file) {
		if(file.getName().equals(fileName)) {
			foundFiles.add(file);
		}
	}

	public LinkedList<File> getFoundFiles(){
        return foundFiles;
    }
    
}