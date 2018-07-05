package com.kodilla.stream.book;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

public class BookTestSuite {
    @Test
    public void testGetListUsingFor() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        int numberOfBooksPublishedAfter2007 = 0;
        for(Book book : books) {
            if (book.getYearOfPublication() > 2007) {
                numberOfBooksPublishedAfter2007++;
            }
        }
        Assert.assertEquals(3, numberOfBooksPublishedAfter2007);
    }

    @Test
    public void testGetListUsingIntStream() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        int numberOfBooksPublishedAfter2007int = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .map(n -> 1)
                .sum();

        // equivalent, but faster (note that type has to be long)
        long numberOfBooksPublishedAfter2007long = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .count();

//        // Alternative solution - using standard stream() (I like it more, especially the one with count() )
//        int numberOfBooksPublishedAfter2007 = books.stream()
//                .map(book -> book.getYearOfPublication())
//                .filter(year -> year > 2007)
//                .map(year -> 1)
//                .reduce(0, (sum, current) -> sum += current);
//        long numberOfBooksPublishedAfter2007long = books.stream()
//                .filter(book -> book.getYearOfPublication() > 2007)
//                .count();

        Assert.assertEquals(3, numberOfBooksPublishedAfter2007int);
        Assert.assertEquals(3, numberOfBooksPublishedAfter2007long);
    }
}