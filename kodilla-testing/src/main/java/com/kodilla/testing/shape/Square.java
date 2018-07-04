package com.kodilla.testing.shape;

public class Square implements Shape {

    private String name = "square";
    private double area;

    public Square(double sideLength) {
        this.area = sideLength*sideLength;
    }

    public String getName() {
        return this.name;
    }

    public double getArea() {
        return this.area;
    }

    @Override
    public String toString() {
        return "Square{" +
                "name='" + name + '\'' +
                ", area=" + area +
                '}';
    }
}