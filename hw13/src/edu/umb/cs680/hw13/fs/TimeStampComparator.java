package edu.umb.cs680.hw13.fs;
import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement>{

    @Override
    public int compare(FSElement fse1, FSElement fse2) {
        return (int) ((fse1.getCreationtime()).compareTo(fse2.getCreationtime()));
    }
    
}