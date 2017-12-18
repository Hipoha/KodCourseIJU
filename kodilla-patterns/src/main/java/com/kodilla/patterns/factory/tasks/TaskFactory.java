package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Shopping at Safeway","Oranges",5.0);
            case PAINTING:
                return new PaintingTask("Painting a wall","Light orange","northern wall");
            case DRIVING:
                return new DrivingTask("Driving to a shop","Safeway","car");
            default:
                return null;
        }
    }

}
