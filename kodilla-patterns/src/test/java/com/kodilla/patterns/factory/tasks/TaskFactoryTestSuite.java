package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testFactoryShopping() {
        // Given
        TaskFactory taskFactory = new TaskFactory();

        // When
        Task shopping = taskFactory.makeTask(TaskFactory.SHOPPING);
        boolean isExecutedAfterCreation = shopping.isTaskExecuted();
        int execute1 = shopping.executeTask();
        boolean isExecutedAfterExecution = shopping.isTaskExecuted();
        int execute2 = shopping.executeTask();
        boolean isExecutedAfterDoubleExecution = shopping.isTaskExecuted();

        // Then
        Assert.assertEquals("Shopping at Safeway",shopping.getTaskName());
        Assert.assertFalse(isExecutedAfterCreation);
        Assert.assertEquals(1,execute1);
        Assert.assertTrue(isExecutedAfterExecution);
        Assert.assertEquals(-1,execute2);
        Assert.assertTrue(isExecutedAfterDoubleExecution);
    }

    @Test
    public void testFactoryPainting() {
        // Given
        TaskFactory taskFactory = new TaskFactory();

        // When
        Task shopping = taskFactory.makeTask(TaskFactory.PAINTING);
        boolean isExecutedAfterCreation = shopping.isTaskExecuted();
        int execute1 = shopping.executeTask();
        boolean isExecutedAfterExecution = shopping.isTaskExecuted();
        int execute2 = shopping.executeTask();
        boolean isExecutedAfterDoubleExecution = shopping.isTaskExecuted();

        // Then
        Assert.assertEquals("Painting a wall",shopping.getTaskName());
        Assert.assertFalse(isExecutedAfterCreation);
        Assert.assertEquals(1,execute1);
        Assert.assertTrue(isExecutedAfterExecution);
        Assert.assertEquals(-1,execute2);
        Assert.assertTrue(isExecutedAfterDoubleExecution);
    }

    @Test
    public void testFactoryDriving() {
        // Given
        TaskFactory taskFactory = new TaskFactory();

        // When
        Task shopping = taskFactory.makeTask(TaskFactory.DRIVING);
        boolean isExecutedAfterCreation = shopping.isTaskExecuted();
        int execute1 = shopping.executeTask();
        boolean isExecutedAfterExecution = shopping.isTaskExecuted();
        int execute2 = shopping.executeTask();
        boolean isExecutedAfterDoubleExecution = shopping.isTaskExecuted();

        // Then
        Assert.assertEquals("Driving to a shop",shopping.getTaskName());
        Assert.assertFalse(isExecutedAfterCreation);
        Assert.assertEquals(1,execute1);
        Assert.assertTrue(isExecutedAfterExecution);
        Assert.assertEquals(-1,execute2);
        Assert.assertTrue(isExecutedAfterDoubleExecution);
    }

}
