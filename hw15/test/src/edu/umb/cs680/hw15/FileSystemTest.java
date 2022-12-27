package edu.umb.cs680.hw15;


import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.Test;

import edu.umb.cs680.hw15.fs.FSElement;
import edu.umb.cs680.hw15.fs.FileSystem;

public class FileSystemTest {
    TestFixtureInitializer TFS = new TestFixtureInitializer();
    FileSystem fs = TestFixtureInitializer.createFS();

    @Test
    public void checkAlphabeticalComparator(){
        LinkedList<FSElement> output = new LinkedList<FSElement>();
        output= fs.getRootDirs().getChildren(); // no parameter -> alphabetical sorting

        LinkedList<String> actual = new LinkedList<String>();
        for(FSElement fse : output){
            actual.add(fse.getName());
        }
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("Apps");
        expected.add("home");
        expected.add("lib");
        //A followed by "h" followed by "l" 
        assertEquals(expected, actual);
    }

    @Test
    public void checkSizeComparator(){
        LinkedList<FSElement> output = new LinkedList<FSElement>();
        output= fs.getRootDirs().getChildren((FSElement fse1, FSElement fse2)-> (int)(fse1.getSize() - fse2.getSize()));

        LinkedList<String> actual = new LinkedList<String>();
        for(FSElement fse : output){
            actual.add(fse.getName());
        }
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("Apps");
        expected.add("home");
        expected.add("lib");
        assertEquals(expected, actual);
    }

    @Test
    public void checkTimeStampComparator(){
        LinkedList<FSElement> output = new LinkedList<FSElement>();
        output= fs.getRootDirs().getChildren((FSElement fse1, FSElement fse2) -> (int)((fse1.getCreationtime()).compareTo(fse2.getCreationtime())));

        LinkedList<String> actual = new LinkedList<String>();
        for(FSElement fse : output){
            actual.add(fse.getName());
        }
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("Apps");
        expected.add("home");
        expected.add("lib");
        assertEquals(expected, actual);
    }
     
    @Test
    public void checkReverseAlphabeticalComparator(){
        LinkedList<FSElement> output = new LinkedList<FSElement>();
        output= fs.getRootDirs().getChildren((FSElement fse1, FSElement fse2)->fse2.getName().compareTo(fse1.getName()));

        LinkedList<String> actual = new LinkedList<String>();
        for(FSElement fse : output){
            actual.add(fse.getName());
        }
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("lib");
        expected.add("home");
        expected.add("Apps");
        assertEquals(expected, actual);
    }
}
