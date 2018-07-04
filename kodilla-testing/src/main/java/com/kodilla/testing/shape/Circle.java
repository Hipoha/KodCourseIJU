package com.kodilla.testing.shape;

public class Circle implements Shape {

    private String name = "circle";
    private double area;

    public Circle(double radius) {
        this.area = 3.141_592_653_589_793_238*radius*radius;
    }

    public String getName() {
        return this.name;
    }

    public double getArea() {
        return this.area;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "name='" + name + '\'' +
                ", area=" + area +
                '}';
    }
}
