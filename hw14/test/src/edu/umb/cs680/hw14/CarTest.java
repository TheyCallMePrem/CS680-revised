package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import org.junit.Test;

public class CarTest {
    Car c1= new Car("BMW","M8 Coupe" , 10 , 2019, 131995);
    Car c2= new Car("Mercedes-Benz","EQS Sedan" , 20 , 2021, 151050 );
    Car c3= new Car("Bentley","Continental gt" , 5 , 2003, 240000 );

        

    @Test
    public void checkMilageComparatorSort(){
        LinkedList<Car> cars = new LinkedList<Car>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);

        Collections.sort(cars, Comparator.comparing(car -> car.getMileage(),Comparator.reverseOrder()));
        LinkedList<String> SortedCarNamesByMilage = new LinkedList<String>();
        for(Car car : cars){
            SortedCarNamesByMilage.add("Car : " + car.getMake() + car.getModel());

        }
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("Car : Mercedes-BenzEQS Sedan");
        expected.add("Car : BMWM8 Coupe");
        expected.add("Car : BentleyContinental gt");

        assertEquals(expected, SortedCarNamesByMilage);
        //Car : Mercedes-BenzEQS Sedan milage =20, Car : BMWM8 Coupe milage =10, Car : BentleyContinental gt milage =5
    }

    @Test
    public void checkPriceComparatorSort(){
        LinkedList<Car> cars = new LinkedList<Car>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);

        Collections.sort(cars, Comparator.comparing(car -> car.getPrice()));
        LinkedList<String> SortedCarNamesByPrice = new LinkedList<String>();
        for(Car car : cars){
            SortedCarNamesByPrice.add("Car : " + car.getMake() + car.getModel());

        }
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("Car : BMWM8 Coupe");
        expected.add("Car : Mercedes-BenzEQS Sedan");
        expected.add("Car : BentleyContinental gt");

        assertEquals(expected, SortedCarNamesByPrice);
        //Car : BentleyContinental gt price =240000.0, Car : BMWM8 Coupe price =131995.0, Car : Mercedes-BenzEQS Sedan price =151050.0
    }

    @Test
    public void checkYearComparatorSort(){
        LinkedList<Car> cars = new LinkedList<Car>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);

        Collections.sort(cars, Comparator.comparing(car -> car.getYear(),Comparator.reverseOrder()));
        LinkedList<String> SortedCarNamesByYear = new LinkedList<String>();
        for(Car car : cars){
            SortedCarNamesByYear.add("Car : " + car.getMake() + car.getModel());

        }
        LinkedList<String> expected = new LinkedList<String>();
        
        expected.add("Car : Mercedes-BenzEQS Sedan");
        expected.add("Car : BMWM8 Coupe");
        expected.add("Car : BentleyContinental gt");
        //[Car : Mercedes-BenzEQS Sedan year =2021, Car : BMWM8 Coupe year =2019, Car : BentleyContinental gt year =2003]
        assertEquals(expected, SortedCarNamesByYear);
    }
}
