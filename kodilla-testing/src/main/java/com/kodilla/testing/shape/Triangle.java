package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private String name = "triangle";
    private double area;

    public Triangle(double baseLength, double height) {
        this.area = 0.5*baseLength*height;
    }

    public String getName() {
        return this.name;
    }

    public double getArea() {
        return this.area;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "name='" + name + '\'' +
                ", area=" + area +
                '}';
    }
}