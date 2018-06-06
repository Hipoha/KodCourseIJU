package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaOrder() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        //Then
        assertEquals(new BigDecimal(15), pizzaOrder.getCost());
        assertEquals("Order: Pizza", pizzaOrder.getDescription());
    }
    @Test
    public void testPizzaWithCheeseOrder() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new CheeseDecorator(pizzaOrder);
        //When
        //Then
        assertEquals(new BigDecimal(18), pizzaOrder.getCost());
        assertEquals("Order: Pizza with\n   additional cheese", pizzaOrder.getDescription());
    }
}
