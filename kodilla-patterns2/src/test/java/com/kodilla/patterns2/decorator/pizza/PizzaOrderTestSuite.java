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
        assertEquals(new BigDecimal(17), pizzaOrder.getCost());
        assertEquals("Order: Pizza with\n   additional cheese", pizzaOrder.getDescription());
    }
    @Test
    public void testPizzaWithCheeseShrimpOrder() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new CheeseDecorator(pizzaOrder);
        pizzaOrder = new ShrimpDecorator(pizzaOrder);
        //When
        //Then
        assertEquals(new BigDecimal(21), pizzaOrder.getCost());
        assertEquals("Order: Pizza with\n   additional cheese\n   shrimp", pizzaOrder.getDescription());
    }
    @Test
    public void testPizzaWithHamShrimpPineappleOrder() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new ShrimpDecorator(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);
        //When
        //Then
        assertEquals(new BigDecimal(24), pizzaOrder.getCost());
        assertEquals("Order: Pizza with\n   ham\n   shrimp\n   pineapple", pizzaOrder.getDescription());
    }
}
