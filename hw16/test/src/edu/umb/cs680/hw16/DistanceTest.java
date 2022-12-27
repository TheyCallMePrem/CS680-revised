package edu.umb.cs680.hw16;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
public class DistanceTest {
    Distance d = new Distance(); 

    List<Double> p1 = new LinkedList<Double>(Arrays.asList(0.4, 1.1, 9.9)); //Three dimentinal float point #1
    List<Double> p2 = new LinkedList<Double>(Arrays.asList(1.2, 3.4, 5.6)); //Three dimentinal float point #2
    List<Double> p3 = new LinkedList<Double>(Arrays.asList(7.8, 9.1, 11.12)); //Three dimentinal float point #3
    List<Double> p4 = new LinkedList<Double>(Arrays.asList(13.14, 15.16, 17.18)); //Three dimentinal float point #4
    List<Double> p5 = new LinkedList<Double>(Arrays.asList(0.0, 0.0, 0.0)); //Three dimentinal float point #5

    List<List<Double>> pointsList=  new LinkedList<List<Double>>(Arrays.asList(p1, p2, p3, p4,p5));

    @Test
    public void checkEuclideandistancebetween_P1_P2(){
        double actual = Distance.get(p1, p2);
        double expected = 4.941659640242335;
        assertEquals(expected, actual);
    }

    @Test
    public void checkManhattandistancebetween_P4_P5(){
        
        double actual = Distance.get(p4, p5, (p4, p5) -> {
			double distance = 0;
			for(int i=0; i < p1.size(); i++){
				distance += Math.abs(p4.get(i) - p5.get(i));
			} 
            return distance;}
            );
        double expected = 45.480000000000004;
        assertEquals(expected, actual);
    }

    @Test
    public void checkCanberradistancebetween_P5_P3(){
        
        double actual = Distance.get(p5, p3, (p5, p3) -> {
            double sumCanberra = 0.0;
            for(int i=0; i < p1.size(); i++) {
                sumCanberra += (Math.abs(p5.get(i)-p3.get(i)) / Math.abs(p3.get(i)) + Math.abs(p3.get(i)) );
            }
            return sumCanberra;
        });
        double expected = 31.019999999999996;
        assertEquals(expected, actual);
    }

    @Test
    public void checkMatrixMethodReturnsAnArrayList(){
        List<List<Double>> resultMatrix= Distance.matrix(pointsList);

        assertEquals("class java.util.ArrayList", resultMatrix.getClass().toString());
    }

    

    @Test
    public void checkEuclideanMatrixMethodReturnsAnArrayListofSize5x5(){
        List<List<Double>> resultMatrix= Distance.matrix(pointsList); 
        int actualRows= resultMatrix.size(); //Expected number of rows
        int actualCols= resultMatrix.get(0).size();//Expected number of columns

        List<Integer> actual =new LinkedList<Integer>(Arrays.asList(actualRows, actualCols));
        List<Integer> expected =new LinkedList<Integer>(Arrays.asList(5, 5));

        assertEquals(expected, actual);
    }

    @Test
    public void checkManhattanMatrixMethodReturnsAnArrayListofSize5x5(){
        
        List<List<Double>> resultMatrix= Distance.matrix(pointsList, (p1, p2) -> {
			double distance = 0;
			for(int i=0; i < p1.size(); i++){
				distance += Math.abs(p1.get(i) - p2.get(i));
			} 
            return distance;}); 
        int actualRows= resultMatrix.size(); //Expected number of rows
        int actualCols= resultMatrix.get(0).size();//Expected number of columns

        List<Integer> actual =new LinkedList<Integer>(Arrays.asList(actualRows, actualCols));
        List<Integer> expected =new LinkedList<Integer>(Arrays.asList(5, 5));

        assertEquals(expected, actual);
    }

    
}

//
// (p1, p2) -> {
//     double distance = 0;
//     for(int i=0; i < p1.size(); i++){
//         distance += Math.abs(p1.get(i) - p2.get(i));
//     } 
//     return distance;}





            
