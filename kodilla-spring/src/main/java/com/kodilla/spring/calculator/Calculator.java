package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    @Autowired
    private Display display;

    public double add(double a, double b) {
        double result = a + b;
        display.displayValue(result);
        return result;
    }

    public double multiply(double a, double b) {
        double result = a * b;
        display.displayValue(result);
        return result;
    }

    public double additiveInverse(double a) {
        double result = -a;
        display.displayValue(result);
        return result;
    }

    public double multiplicativeInverse(double a) {
        double result = 1/a;
        display.displayValue(result);
        return result;
    }

}
