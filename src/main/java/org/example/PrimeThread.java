package org.example;

public class PrimeThread extends Thread {

    private final Iterator iterator;
    private final int id;

    public PrimeThread(Iterator iterator, int id) {
        this.iterator = iterator;
        this.id = id;
    }
    @Override
    public void run() {
        int number = iterator.getAndIncrement();
        // number - число проверяемое потоком, берётся из итератора , который постоянно обновляется другими потоками
        while (number < iterator.getMax()) {
            if (isPrime(number)) {
                System.out.println("thread " + this.id + " " + number);
                iterator.addIntToPrimes(number);
            }
            number = iterator.getAndIncrement();
        }
    }
    // Проверка на простоту
    public synchronized boolean isPrime(int number) {
        if (number <= 1 || number == 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
