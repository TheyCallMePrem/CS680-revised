package edu.umb.cs680.hw13.fs;
import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {
    public int compare(FSElement fse1, FSElement fse2) {
		return fse2.getName().compareTo(fse1.getName());
	}
}