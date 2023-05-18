package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PrimeFinder {
    private Iterator iterator;
    private int threads;

    public PrimeFinder(int min, int max, int threads) {
        this.threads = threads;
        this.iterator = new Iterator(min, max);
    }

    public Set<Integer> getPrimesHashSet() throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        // Создание тредов
        for (int i = 0; i < threads; i++) {
            threadList.add(new PrimeThread(iterator, i));
        }
        // запуск тредов
        for (int i = 0; i < threads; i++) {
            threadList.get(i).start();
        }
        //Ожадание потоков, без этого метод вовзращает сет раньше чем отрабатывают потоки
        for (int i = 0; i < threads; i++) {
            threadList.get(i).join();
        }

        return iterator.getPrimes();
    }

}
