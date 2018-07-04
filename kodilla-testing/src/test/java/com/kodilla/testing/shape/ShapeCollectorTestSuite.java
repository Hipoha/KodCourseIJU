package com.kodilla.testing.shape;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Starting tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests finished.");
    }

    @Before
    public void beforeEachTest() {
        testCounter++;
        System.out.println("Test #" + testCounter);
    }

    @Test
    public void testAddShape() {
        // Given
        ShapeCollector testCollection = new ShapeCollector(
                new ArrayList<>(
                        Arrays.asList(
                                new Circle(1.0),
                                new Triangle(2.0,1.0)
                        )));
        ShapeCollector expectedCollection = new ShapeCollector(
                new ArrayList<>(
                        Arrays.asList(
                                new Circle(1.0),
                                new Triangle(2.0,1.0),
                                new Square(2.0)
                        )));
        // When
        testCollection.addShape(new Square(2.0));
        // Then
        Assert.assertEquals(expectedCollection.getShapeList().size(),testCollection.getShapeList().size());
    }

    @Test
    public void testRemoveShape() {
        // Given
        Circle circle = new Circle(1.0);
        Square square = new Square(2.0);
        Triangle triangle = new Triangle(2.0,2.0);
        ShapeCollector testCollection = new ShapeCollector(
                new ArrayList<>(
                        Arrays.asList(
                                circle,
                                triangle,
                                square
                        )));
        ShapeCollector expectedCollection = new ShapeCollector(
                new ArrayList<>(
                        Arrays.asList(
                                circle,
                                square
                        )));
        // When
        testCollection.removeShape(triangle);
        // Then
        Assert.assertEquals(expectedCollection.getShapeList().size(),testCollection.getShapeList().size());
    }

    @Test
    public void testGetShape() {
        // Given
        Circle circle = new Circle(1.0);
        Square square = new Square(2.0);
        Triangle triangle = new Triangle(2.0,2.0);
        ShapeCollector testCollection = new ShapeCollector(
                new ArrayList<>(
                        Arrays.asList(
                                circle,
                                square,
                                triangle
                        )));
        // When
        Shape shape1 = testCollection.getShape(-1);
        Shape shape2 = testCollection.getShape(1);
        Shape shape3 = testCollection.getShape(3);
        // Then
        Assert.assertEquals(null,shape1);
        Assert.assertEquals(square,shape2);
        Assert.assertEquals(null,shape3);
    }

}
