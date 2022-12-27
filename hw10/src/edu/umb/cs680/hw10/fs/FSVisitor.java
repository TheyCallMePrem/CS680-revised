package edu.umb.cs680.hw10.fs;

public interface FSVisitor {
    public void visit(Link link); //Link visitor method
    public void visit(Directory dir); //Directory visitor method
    public void visit(File file); //File visitor method
}
