package it.com.retrofitdemo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tony on 2017/5/22.
 */
public class CalculateTest {
    @Test
    public void testCalculator() {
        Calculate calculate = new Calculate();
        int calculator = calculate.calculator(1, 1);
        assertEquals(2, calculator);
    }
}
