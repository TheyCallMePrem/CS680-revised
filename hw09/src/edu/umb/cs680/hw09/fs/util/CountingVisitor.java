package edu.umb.cs680.hw09.fs.util;


import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.FSVisitor;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;

public class CountingVisitor implements FSVisitor{
    

    private int dirNum = 0;
	private int fileNum = 0;
	private int linkNum = 0;
    @Override
    public void visit(Link link) {
        linkNum++;
    }

    @Override
    public void visit(Directory dir) {
        fileNum++;
    }

    @Override
    public void visit(File file) {
        dirNum++;
    }

    public int totalElementsVisited(){
        return (linkNum + fileNum + dirNum);
    }

    public int getdirNum(){
        return dirNum;
    }

    public int getfileNum(){
        return fileNum;
    }

    public int getlinkNum(){
        return linkNum;
    }
    
}
