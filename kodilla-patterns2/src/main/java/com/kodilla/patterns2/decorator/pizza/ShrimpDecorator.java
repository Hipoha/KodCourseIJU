package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ShrimpDecorator extends AbstractPizzaOrderDecorator {

    public ShrimpDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(4));
    }

    @Override
    public String getDescription() {
        String oldDescription = super.getDescription();
        if (oldDescription == "Order: Pizza") {
            oldDescription += " with";
        }
        return oldDescription + "\n   shrimp";
    }
}