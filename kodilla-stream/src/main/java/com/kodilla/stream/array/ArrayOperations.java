package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {

        if (numbers.length == 0) {
            System.out.println("CAUTION! The list was empty! Returned -1.0 as average.");
            return -1.0;
        }

        IntStream.range(0,numbers.length)
                .forEach(index -> System.out.println("Element " + index + ": " + numbers[index]));

        return IntStream.range(0, numbers.length)
                .map(index -> numbers[index])
                .average().getAsDouble();
    }
}
