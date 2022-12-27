package edu.umb.cs680.hw12;

import java.util.LinkedList;
import java.util.Collections;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
public class ComparatorsTest {
    LinkedList<Car> Cars = new LinkedList<Car>();
        Car c1= new Car("BMW","M8 Coupe" , 15 , 2019, 131995);
        Car c2= new Car("Mercedes-Benz","EQS Sedan" , 20 , 2021, 151050 );
        Car c3= new Car("Bentley","Continental gt" , 20 , 2003, 240000 );

        @Test
        public void checkMilageComparatorSort(){
            Cars.add(c1);
            Cars.add(c2);
            Cars.add(c3);

            LinkedList<Car> expected = new LinkedList<Car>();
            expected.add(c1);      
            expected.add(c2);
            expected.add(c3);

            Collections.sort(Cars, new MileageComparator());
            Assert.assertArrayEquals(expected.toArray(), Cars.toArray());
        }
        @Test
        public void checkPriceComparatorSort(){
            Cars.add(c1);
            Cars.add(c2);
            Cars.add(c3);

            LinkedList<Car> expected = new LinkedList<Car>();
            expected.add(c1);      
            expected.add(c2);
            expected.add(c3);

            Collections.sort(Cars, new PriceComparator());
            Assert.assertArrayEquals(expected.toArray(), Cars.toArray());
        }
        @Test
        public void checkParetoComparatorSort(){
            Cars.add(c1);
            Cars.add(c2);
            Cars.add(c3);

            LinkedList<Car> expected = new LinkedList<Car>();
            expected.add(c1);      
            expected.add(c2);
            expected.add(c3);

            Collections.sort(Cars, new ParetoComparator());
            Assert.assertArrayEquals(expected.toArray(), Cars.toArray());
        }
        @Test
        public void checkYearComparatorSort(){
            Cars.add(c1);
            Cars.add(c2);
            Cars.add(c3);

            LinkedList<Car> expected = new LinkedList<Car>();
            expected.add(c2);      
            expected.add(c1);
            expected.add(c3);

            Collections.sort(Cars, new YearComparator());
            Assert.assertArrayEquals(expected.toArray(), Cars.toArray());
        }
}
