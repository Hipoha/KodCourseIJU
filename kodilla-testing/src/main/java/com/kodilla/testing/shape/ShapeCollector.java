package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    // Fields
    private ArrayList<Shape> shapeList = new ArrayList<>();

    // Constructor
    public ShapeCollector() {
        this(new ArrayList<>());
    }
    public ShapeCollector(ArrayList<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    // Methods
    public void addShape(Shape shape) {
        shapeList.add(shape);
    }

    public void removeShape(Shape shape) {
        shapeList.remove(shape);
    }

    public Shape getShape(int i) {
        if (i >= 0 && i < shapeList.size()) {
            return shapeList.get(i);
        } else {
            System.out.println("No element with index " + i + ". List size is " + shapeList.size() + ".");
            return null;
        }
    }

    public void printShapes() {
        for (Shape shape : this.shapeList) {
            System.out.println(shape.toString());
        }
    }

    // Getters

    public ArrayList<Shape> getShapeList() {
        return shapeList;
    }
}
