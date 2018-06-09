package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {

    MedianAdapter medianAdapter = new MedianAdapter();

    @Test
    public void publicationYearMedianTest() {
        //Given
        Book book1 = new Book("Bing", "Autobiografia", 1939, "38205");
        Book book2 = new Book("Sula", "Mój przyjaciel Bing", 1992, "38206");
        Book book3 = new Book("Pando", "Prawdziwy Bing", 1982, "38207");
        Book book4 = new Book("Flop", "Przygody Binga", 1940, "38208");
        Book book5 = new Book("Amma", "Słowo o Bingu", 1959, "38209");
        Set<Book> bookSetOdd = new HashSet<>();
        Set<Book> bookSetEven = new HashSet<>();
        bookSetOdd.add(book1);
        bookSetOdd.add(book2);
        bookSetOdd.add(book3);
        bookSetOdd.add(book4);
        bookSetOdd.add(book5);
        bookSetEven.add(book1);
        bookSetEven.add(book2);
        bookSetEven.add(book3);
        bookSetEven.add(book4);
        //When
        int medianOdd = medianAdapter.publicationYearMedian(bookSetOdd);
        int medianEven = medianAdapter.publicationYearMedian(bookSetEven);
        //Then
        assertEquals(1959, medianOdd);
        assertEquals(1961, medianEven);
    }
}
