package edu.umb.cs680.hw12;

import java.util.LinkedList;

public class Car {
	private String make;
	private String model;
	private int mileage;
	private int year;
	private float price;
	private int dominationCount;
	
	public Car(String make, String model, int mileage, int year, float price) {
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}

    // Getters for make,  model,mileage , year, price , dominationCount and setter for dominationCount
	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}

	public float getPrice() {
		return price;
	}

	public int getDominationCount() {
		return dominationCount;
	}
	
	public void setDominationCount(LinkedList<Car> cars) {
		this.dominationCount = 0;
		for (Car car : cars) {
			if(car.getYear() >= this.getYear() && car.getMileage() <= this.getMileage() && car.getPrice() <= this.getPrice()) 
            { //  Checking if A’s objective values are superior than, or equal to, B’s in all objectives
                
				if(car.getYear() > this.getYear() || car.getMileage() < this.getMileage() || car.getPrice() < this.getPrice()) {
                    // Checking A’s objective values are superior than B’s in at least one objective
					dominationCount++;
				}
			}
		}
	}
    
    public static void main(String[] args){
        Car c1= new Car("BMW","M8 Coupe" , 15 , 2019, 131995);
        Car c2= new Car("Mercedes-Benz","EQS Sedan" , 20 , 2021, 151050 );
        Car c3= new Car("Bentley","Continental gt" , 20 , 2003, 240000 );

        LinkedList<Car> cars = new LinkedList<Car>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);

        c1.setDominationCount(cars);
        c2.setDominationCount(cars);
        c3.setDominationCount(cars);

        System.out.println(c1.getDominationCount());
        System.out.println(c2.getDominationCount());
        System.out.println(c3.getDominationCount());

    }
}
