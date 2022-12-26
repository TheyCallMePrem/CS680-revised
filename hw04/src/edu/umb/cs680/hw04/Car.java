package edu.umb.cs680.hw04;

public class Car {
    private String make, model;
    private int mileage, year;
    private float price;

    public Car(String make, String model, int year) {
        super();
        if (make == null || model == null || year == 0) {
            throw new IllegalArgumentException("Parameter cannot be null");
        }
        if (year > 2022) {
            throw new IllegalArgumentException("Illegal input value, year can't be future date ");
        }
        if(year <0){
            throw new IllegalArgumentException("Illegal input value, year can't be negetive value");
        }
        this.make = make;
        this.model = model;
        this.year = year;
    }


    // public Car(int make, int model, int year) {
    //     throw new RuntimeException("Illegal input values, make and model should be String");
    // }


    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
    // Protected setter methods for milage and price (Avoided public access specifier on pourpouse )
    protected int setMilage(int m){
        this.mileage=m;
        return mileage;
    }

    protected float setPrice(float p){
        this.price=p;
        return price;
    }

    // Public getter methods for milage and price 

    public int getMilage() {
        return mileage;
    }

    public float getPrice() {
        return price;
    }
    public static void main(String[] args){
        Car c1 = new Car("Toyota", "RAV4", 2018);

        c1.setMilage(5);
        c1.setPrice(123456.789f);

        System.out.println("getMake() : " + c1.getMake());
        System.out.println("getModel() : " + c1.getModel());
        System.out.println("getYear() : " + c1.getYear());
        
        System.out.println("getMake() : " + c1.getMilage());
        System.out.println("getModel() : " + c1.getPrice());
    }
}
