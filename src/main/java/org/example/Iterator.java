package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Iterator {
    //Проверяемое число
    private int anInt;
    // Lower bound
    private final int min;
    // Upper bound
    private final int max;
    //All primes
    private final Set<Integer> primes = new HashSet<>();

    public Iterator(int min, int max) {
        this.min = min;
        this.max = max;
        // Т.к метод гетАндИнкремент сначало увеливает, то существует необходимость уменьшить число на 1
        // В Случае если оно нечётно, чтобы не забыть его проверить
        this.anInt = min % 2 == 0 ? min : min - 1;
    }

    public Set<Integer> getPrimes() {
        return primes;
    }

    public synchronized int getAnInt() {
        return anInt;
    }

    public synchronized void addIntToPrimes(Integer n) {
        primes.add(n);
    }

    public synchronized void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    // Дать возможность тредам увеличивать число, ими проверяемое
    public synchronized int getAndIncrement() {
        this.anInt = anInt + 1;
        return this.anInt;
    }

    public synchronized void increment() {
        this.anInt++;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
