package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        // Given
        int[] numbers = new int[] {23,34,56};
        // When
        double actual = ArrayOperations.getAverage(new int[]{23,34,56});
        // Then
        Assert.assertEquals(37.666_666_666_666_667,actual,0.000_000_000_001);
    }
}
