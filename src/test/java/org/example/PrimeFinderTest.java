package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeFinderTest {

    @Test
    void getPrimesHashSet() throws InterruptedException {
        int threads = 2;
        int threads1 = 5;
        int min = 1;
        int max = 10;
        int min1 = 10;
        int max1 = 100;
        Set<Integer> set = new HashSet<>(List.of(3, 5, 7));
        Set<Integer> set1 = new HashSet<>(List.of(11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
        PrimeFinder primeFinder = new PrimeFinder(min, max, threads);
        PrimeFinder primeFinder1 = new PrimeFinder(min1, max1, threads1);
        Set<Integer> integers = primeFinder.getPrimesHashSet();
        Set<Integer> integers1 = primeFinder1.getPrimesHashSet();
        Assertions.assertEquals(set, integers);
        Assertions.assertEquals(set1, integers1);
    }

}