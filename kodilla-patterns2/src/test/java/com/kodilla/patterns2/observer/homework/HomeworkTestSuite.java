package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeworkTestSuite {
    @Test
    public void testUpdate() {
        //Given
        Mentor flop = new Mentor("Flop");
        Mentor amma = new Mentor("Amma");
        Mentor pola = new Mentor("Pola");
        Participant bing = new Participant("Bing", flop);
        Participant sula = new Participant("Sula", amma);
        Participant pando = new Participant("Pando", pola);
        //When
        bing.addTask("Catch a butterfly");
        sula.addTask("Buy a toy");
        sula.addTask("Take a shower");
        bing.addTask("Prepare a cocktail");
        pando.addTask("Play football");
        bing.addTask("Paint a landscape");
        //Then
        assertEquals(3,flop.getUpdateCount());
        assertEquals(2,amma.getUpdateCount());
        assertEquals(1,pola.getUpdateCount());
    }
}
