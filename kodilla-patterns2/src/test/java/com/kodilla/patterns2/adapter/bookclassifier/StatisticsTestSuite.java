package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Statistics;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StatisticsTestSuite {
    Statistics statistics = new Statistics();

    @Test
    public void testMedian() {
        //Given
        BookSignature signature1 = new BookSignature("38205");
        BookSignature signature2 = new BookSignature("38206");
        BookSignature signature3 = new BookSignature("38207");
        BookSignature signature4 = new BookSignature("38208");
        BookSignature signature5 = new BookSignature("38209");
        Book book1 = new Book("Bing", "Autobiografia", 1939);
        Book book2 = new Book("Sula", "Mój przyjaciel Bing", 1992);
        Book book3 = new Book("Pando", "Prawdziwy Bing", 1982);
        Book book4 = new Book("Flop", "Przygody Binga", 1940);
        Book book5 = new Book("Amma", "Słowo o Bingu", 1959);
        Map<BookSignature, Book> booksOdd = new HashMap<>();
        Map<BookSignature, Book> booksEven = new HashMap<>();
        booksOdd.put(signature1, book1);
        booksOdd.put(signature2, book2);
        booksOdd.put(signature3, book3);
        booksOdd.put(signature4, book4);
        booksOdd.put(signature5, book5);
        booksEven.put(signature1, book1);
        booksEven.put(signature2, book2);
        booksEven.put(signature3, book3);
        booksEven.put(signature4, book4);
        //When
        int medianOdd = statistics.medianPublicationYear(booksOdd);
        int medianEven = statistics.medianPublicationYear(booksEven);
        //Then
        System.out.println("Median of the odd set: " + medianOdd);
        System.out.println("Median of the even set: " + medianEven);
        assertEquals(1959,medianOdd);
        assertEquals(1961,medianEven);
    }
}
