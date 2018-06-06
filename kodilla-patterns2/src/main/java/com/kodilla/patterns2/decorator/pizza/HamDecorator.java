package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class HamDecorator extends AbstractPizzaOrderDecorator {

    public HamDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        String oldDescription = super.getDescription();
        if (oldDescription == "Order: Pizza") {
            oldDescription += " with";
        }
        return oldDescription + "\n   ham";
    }
}