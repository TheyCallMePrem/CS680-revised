package edu.umb.cs680.hw02;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class PrimeGeneratorTest {
    @Test
    public void LowerBoundLessThanUpperBound()
    {
        try {
            PrimeGenerator PG  = new PrimeGenerator(10,10);
        }
        catch(Exception e) {
            assertEquals("Wrong input values: from=10 to=10" ,e.getMessage());
        }
    }
    @Test
    public void LowerBoundAndUpperBoundGraterThanZero()
    {
        try {
            PrimeGenerator PG  = new PrimeGenerator(-1,0);
        }
        catch(Exception e) {
            assertEquals("Wrong input values: from=-1 to=0" ,e.getMessage());
        }
    }
    @Test
    public void FourPrimesFor1To8()
    {
        PrimeGenerator PG = new PrimeGenerator(1,8);
        PG.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L};
        assertArrayEquals( expectedPrimes, PG.getPrimes().toArray() );
    }
    @Test
    public void NoPrimeInRange32To36()
    {
        PrimeGenerator PG = new PrimeGenerator(32,36);
        PG.generatePrimes();
        Long[] expectedPrimes = {};
        assertArrayEquals(expectedPrimes, PG.getPrimes().toArray());
    }
    @Test
    public void OnePrimeInRange100To102()
    {
        PrimeGenerator PG = new PrimeGenerator(100,102);
        PG.generatePrimes();
        Long[] expectedPrimes = {101L};
        assertArrayEquals( expectedPrimes, PG.getPrimes().toArray() );
    }
}
