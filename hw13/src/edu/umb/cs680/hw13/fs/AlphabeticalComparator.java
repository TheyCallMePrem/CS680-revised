package edu.umb.cs680.hw13.fs;
import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement>{

	public int compare(FSElement fse1, FSElement fse2) {
		return fse1.getName().compareTo(fse2.getName());
	}
}