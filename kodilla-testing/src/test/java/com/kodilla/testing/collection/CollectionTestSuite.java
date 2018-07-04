package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionTestSuite {

    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        System.out.println("     name: testOddNumbersExterminatorEmptyList()");
        ArrayList<Integer> emptyList = new ArrayList<>();
        //When
        ArrayList<Integer> actual = OddNumbersExterminator.exterminate(emptyList);
        //Then
        Assert.assertEquals(emptyList,actual);
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        System.out.println("     name: testOddNumbersExterminatorNormalList()");
        ArrayList<Integer> normalList = new ArrayList<>(Arrays.asList(3,4,7,8,23,53,346,5447,7520));
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(4,8,346,7520));
        //When
        ArrayList<Integer> actual = OddNumbersExterminator.exterminate(normalList);
        //Then
        Assert.assertEquals(expected,actual);
    }

}