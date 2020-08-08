package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class Main {

    public static int fibonacci(int n) {
        if (n > 1) {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
        return n;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            numbers.add(scanner.nextInt());
        }

        List<Integer> sortedNumbers = numbers
                .stream()
                .sorted(Comparator.naturalOrder())
                .collect(toList());

        int startIndex = sortedNumbers.get(0);
        int endIndex = sortedNumbers.get(sortedNumbers.size() - 1);

        List<Integer> fibonacciList = new ArrayList<>();
        for (int i = startIndex; i < endIndex; i++) {
            fibonacciList.add(fibonacci(i));
        }

        for (int fibonacci : fibonacciList) {
            for (int j = 0; j < numbers.size(); j++) {
                int number = numbers.get(j);
                if (fibonacci > number) {
                    System.out.println(fibonacci);
                    numbers.remove(j);
                }
            }
        }
    }
}
