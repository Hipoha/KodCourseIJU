package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void TestBigmacBuilder() {
        // Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .roll("With sesame")
                .burgers(2)
                .sauce("Standard")
                .ingredient("Onion")
                .ingredient("Cheese")
                .ingredient("Lettuce")
                .ingredient("Shrimps")
                .build();
        System.out.println(bigmac);

        // When
        int numOfIngredients = bigmac.getIngredients().size();

        // Then
        Assert.assertEquals(4,numOfIngredients);

    }

}
