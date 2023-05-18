package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    // fixme тест для 6 что правильное число что правильные простые числа в заданном диапозоне
    // тест где осуществлять сортировку?
    public static void main(String[] args) throws Exception {
        System.out.print("Введите нижнюю границу поиска (>0): ");
        int min = scanner.nextInt();
        System.out.print("Введите верхнюю границу поиска (больше нижней границы): ");
        int max = scanner.nextInt();
        System.out.println("Введите количество потоков [1; 10]: ");
        int threads = scanner.nextInt();
        if (max < min) throw new RuntimeException("Min больше, чем Max");
        if (threads < 1 || threads > 10) throw new RuntimeException("threads должен принадлежать [1,10]");
        PrimeFinder primeFinder = new PrimeFinder(min, max, threads);
        Set<Integer> set = primeFinder.getPrimesHashSet();
        System.out.println(set);
    }
}
