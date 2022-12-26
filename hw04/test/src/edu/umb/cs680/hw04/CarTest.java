package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    private String[] str(Car c1) {
        String[] str = new String[3];
        str[0] = c1.getMake();
        str[1] = c1.getModel();
        str[2] = c1.getYear() + "";
        return str;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear() {
        String[] expected = {"Toyota", "RAV4", "2018"};
        Car c1 = new Car("Toyota", "RAV4", 2018);
        assertArrayEquals(expected, str(c1));
    }

    @Test
    public void verifySetterMethodForMilage() {
        Car c1 = new Car("Toyota", "RAV4", 2018);
        int expectedMilage= c1.setMilage(10);
        assertEquals(expectedMilage, c1.getMilage());
    }

    @Test
    public void verifySetterMethodForPrice() {
        Car c1 = new Car("Toyota", "RAV4", 2018);
        float expectedPrice = c1.setPrice(123456.789f);
        assertEquals(expectedPrice, c1.getPrice());
    }

    /* Negative Tests */
    @Test
    public void FutureDateNotAccepted()
    {  
        try {
            Car c1 = new Car("Toyota", "RAV4", 2023);
        }
        catch(Exception e) {
            assertEquals("Illegal input value, year can't be future date " ,e.getMessage());
        }
    }
    
    @Test
    public void NullValuesoNotAccepted()
    {  
        try {
            Car c1 = new Car("Toyota", null, 2018);
        }
        catch(Exception e) {
            assertEquals("Parameter cannot be null" ,e.getMessage());
        }
    }

    @Test
    public void YearLessThanZeroNotAccepted()
    {  
        try {
            Car c1 = new Car("Toyota", "1234", -1);
        }
        catch(Exception e) {
            assertEquals("Illegal input value, year can't be negetive value",e.getMessage());
        }
    }
}
