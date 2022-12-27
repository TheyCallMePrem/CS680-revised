package edu.umb.cs680.hw09.fs;

import java.time.LocalDateTime;

public abstract class FSElement {
    protected String name;
    protected int size;
    protected LocalDateTime dateTime; 
    protected Directory parentDirectory;

    //constructor
    public FSElement(Directory parentDirectory, String name, int size, LocalDateTime dateTime) {
		this.name = name;
		this.size = size;
		this.dateTime = dateTime;
        this.parentDirectory= parentDirectory;
	}

    public int getSize(){
        return this.size;
    }
    public LocalDateTime getCreationtime(){
        return this.dateTime;
    }
    public String getName(){
        return this.name;
    }
    public Directory getparentDirectory(){
        return this.parentDirectory;
    }

    public abstract boolean isDirectory();
    public abstract boolean isProxy();
 
     public abstract void accept(FSVisitor v);
}
