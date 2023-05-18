package org.example;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.*;

public class PrimeThreadTest {

    @Test
    public void isPrime() {
        PrimeThread primeThread = new PrimeThread(new Iterator(2, 1000),1);
        Assert.assertEquals(true, primeThread.isPrime(5));
        Assert.assertEquals(false, primeThread.isPrime(123));
        Assert.assertEquals(false, primeThread.isPrime(771));
    }
}