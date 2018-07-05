package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        // void-returning lambda expression without arguments
        Processor processor = new Processor();
        processor.execute(() -> System.out.println("This is an example text."));

        System.out.println("\n********************************\n");

        // double-returning lambda expression with two arguments
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("\n********************************\n");

        // Static methods
        System.out.println(FunctionalCalculator.addAToB(10.0, 5.0));

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("\n********************************\n");

        // Poem beautifier
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String exampleText = "To jest przykładowy tekst do upiększenia.";
        String beautifiedString1 = poemBeautifier.beautify(exampleText, (text) -> text.toUpperCase());
        String beautifiedString2 = poemBeautifier.beautify(exampleText, (text) -> "|BEG| " + text + " |END|");
        String beautifiedString3 = poemBeautifier.beautify(exampleText, (text) -> {
            String result = "";
            for (char a : text.toCharArray()) {
                result += a + " ";
            }
            return result;
        });
        String beautifiedString4 = poemBeautifier.beautify(exampleText, (text) -> {
            String result = "";
            for (int i=0; i<text.length(); i++) {
                if (i%2 == 0) {
                    result += Character.toUpperCase(text.charAt(i));
                } else {
                    result += Character.toLowerCase(text.charAt(i));
                }
            }
            return result;
        });
        System.out.println(beautifiedString1);
        System.out.println(beautifiedString2);
        System.out.println(beautifiedString3);
        System.out.println(beautifiedString4);

        System.out.println("\n********************************\n");

        // Stream
        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

        System.out.println("\n********************************\n");

        // Stream println
        People.getList().stream()
                .forEach(System.out::println);

        System.out.println("\n********************************\n");

        // Stream map
        People.getList().stream()
                .map(s -> s.toUpperCase())          // .map(String::toUpperCase)
                .forEach(System.out::println);      // .forEach(s -> System.out.println(s));

        System.out.println("\n********************************\n");

        // Stream filter
        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);

        System.out.println("\n********************************\n");

        // Stream kaskadowe łączenie
        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);

        System.out.println("\n********************************\n");

        // Stream na kolekcjach z dowolnymi obiektami
        BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);

        System.out.println("\n********************************\n");

        // Stream: kolektor toList
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);

        System.out.println("\n********************************\n");

        // Stream: kolektor toMap
        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        System.out.println("\n********************************\n");

        // Stream: kolektor joining
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);

        System.out.println("\n********************************\n");

        // Zadanie 7.3
        Forum forum = new Forum();
        Map<Integer, ForumUser> filteredUsers = forum.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> !user.getBirthDate().isAfter(LocalDate.now().minusYears(20)))
                .filter(user -> user.getNumberOfposts() > 0)
                .collect(Collectors.toMap(ForumUser::getUserID, user -> user));

        filteredUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        System.out.println("\n********************************\n");


    }
}