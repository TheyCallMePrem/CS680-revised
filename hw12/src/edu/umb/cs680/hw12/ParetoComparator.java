package edu.umb.cs680.hw12;
import java.util.Comparator;

public class ParetoComparator implements Comparator<Car>{
    public int compare(Car car1, Car car2) {
		return car1.getDominationCount() - car2.getDominationCount();
	}
}
