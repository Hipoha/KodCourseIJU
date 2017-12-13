package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {

        // Given
        Library library = new Library("School library");

        Book book1 = new Book("Biografia Kuratora","Królik Bing",
                LocalDate.of(2010,4,1));
        Book book2 = new Book("Gdzie jest Łukasz","Dinozaur Dino",
                LocalDate.of(2013,7,1));
        Book book3 = new Book("Mój przyjaciel Kurczak Bubu","Kaczor Donald",
                LocalDate.of(2015,1,1));

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        Library libraryShallowCopy = null;
        try {
            libraryShallowCopy = library.shallowCopy();
            libraryShallowCopy.setName("School library shallow copy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library libraryDeepCopy = null;
        try {
            libraryDeepCopy = library.deepCopy();
            libraryShallowCopy.setName("School library deep copy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        // When
        library.getBooks().remove(book1);

        // Then
        System.out.println(library);
        System.out.println(libraryShallowCopy);
        System.out.println(libraryDeepCopy);
        Assert.assertEquals(2,library.getBooks().size());
        Assert.assertEquals(2,libraryShallowCopy.getBooks().size());
        Assert.assertEquals(3,libraryDeepCopy.getBooks().size());
    }

}
