package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    public static ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
        if (numbers.isEmpty()) {
            return numbers;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer element : numbers) {
            if (element % 2 == 0) {
                result.add(element);
            }
        }
        return result;
    }

}