package edu.umb.cs680.hw12;
import java.util.Comparator;

public class YearComparator implements Comparator<Car>{
    public int compare(Car car1, Car car2) {
		return car2.getYear() - car1.getYear(); //Descending
	}
}
