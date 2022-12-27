package edu.umb.cs680.hw15.fs;



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
    @Override
    public boolean isProxy() {
        return  false;
    }
    @Override
    public void accept(FSVisitor v){
        v.visit(this);
    }
}