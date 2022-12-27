package edu.umb.cs680.hw13.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Directory extends FSElement{
    Directory parent;
    private LinkedList<FSElement> children = new LinkedList<FSElement>();
    LinkedList<FSElement> FSlist = new LinkedList<FSElement>();
    LinkedList<Directory> DIRList = new LinkedList<Directory>();
    LinkedList<File> Filelist = new LinkedList<File>();
    LinkedList<Link> ProxyList = new LinkedList<Link>();

    public Directory(Directory parent, String name, int size,LocalDateTime ldt){
        super( parent, name, size, ldt);
        this.parent=parent;
    }

    public LinkedList<FSElement> getChildren()
	{
		children.sort(new AlphabeticalComparator());
		return children;
	}
    

    public LinkedList<FSElement> getChildren(Comparator <FSElement> cfs){
        Collections.sort(children, cfs);
        return this.children;
    }

    public void appendChild(FSElement child){
        FSlist.add(child);

        if(child.isDirectory()){
            DIRList.add((Directory) child);
        }
        else{
            if(child.isProxy()){
                ProxyList.add((Link) child);
            }
            else{
                Filelist.add((File) child);
            }
            
        }
        this.children.add(child);
        Collections.sort(children, new AlphabeticalComparator());
    }

    public int countChildren(){
        return FSlist.size();
    }

    public LinkedList<Directory> getSubDirectories(Comparator <FSElement> cfs){
        return this.DIRList;
    }

    public LinkedList<File> getFiles(Comparator <FSElement> cfs){
        return this.Filelist;
    }

    public int getTotalSize(){
        int totalSize=0;

        for (Directory childDirectory : DIRList) {
            totalSize+= childDirectory.getTotalSize();
        }

        for(File f : Filelist){
            totalSize+= f.getSize();
        }
        return totalSize;
    }

    public Directory getParentDirectory(){
        return this.parent;
    }

    public LinkedList<Link> getProxies(){
        return this.ProxyList;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isProxy() {
        return  false;
    }
    @Override
    public void accept(FSVisitor v){
        for(FSElement e: FSlist){
            e.accept(v); 
        }
    }
}