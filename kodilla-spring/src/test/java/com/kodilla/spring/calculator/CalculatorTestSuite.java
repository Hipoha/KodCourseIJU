package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

public class CalculatorTestSuite {
    @Test
    public void testAdd() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double result = calculator.add(2.0,3.0);
        //Then
        Assert.assertEquals(5.0,result,0.000000000001);
    }

    @Test
    public void testMultiply() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double result = calculator.multiply(2.0,3.0);
        //Then
        Assert.assertEquals(6.0,result,0.000000000001);
    }

    @Test
    public void testAdditiveInverse() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double result = calculator.additiveInverse(2.0);
        //Then
        Assert.assertEquals(-2.0,result,0.000000000001);
    }

    @Test
    public void testMultiplicativeInverse() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double result = calculator.multiplicativeInverse(2.0);
        //Then
        Assert.assertEquals(0.5,result,0.000000000001);
    }

}
