package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public class File extends FSElement {
    protected Directory parent;
    protected String name;

    public File(Directory parent,String name, int size, LocalDateTime ldt){
        super( parent, name, size, ldt);
        
    }

    @Override
    public boolean isDirectory() {
        return false;
    }
}