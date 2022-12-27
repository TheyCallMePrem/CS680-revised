package edu.umb.cs680.hw09.fs.util;

import java.util.LinkedList;

import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.FSVisitor;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;

public class FileCrawlingVisitor implements FSVisitor{
    // Index files in a file system

    private LinkedList<File> files = new LinkedList<>();
    String fileName;

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
        files.add(file);

    }
    public LinkedList<File> getFiles() {
        return files;
    }
}
