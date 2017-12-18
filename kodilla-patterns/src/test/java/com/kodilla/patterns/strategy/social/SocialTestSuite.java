package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class SocialTestSuite {

    @Test
    public void testDefaultSharingStrategies() {

        // Given
        User anna = new Millenials("Anna");
        User bob = new YGeneration("Bob");
        User charlie = new ZGeneration("Charlie");

        // When
        String annaPost = anna.sharePost();
        System.out.println(annaPost);
        String bobPost = bob.sharePost();
        System.out.println(bobPost);
        String charliePost = charlie.sharePost();
        System.out.println(charliePost);

        // Then
        Assert.assertEquals("Facebook is used for sharing.",annaPost);
        Assert.assertEquals("Twitter is used for sharing.",bobPost);
        Assert.assertEquals("Snapchat is used for sharing.",charliePost);
    }

    @Test
    public void testIndividualSharingStrategy() {

        // Given
        User anna = new Millenials("Anna");
        String annaPost = anna.sharePost();
        System.out.println("Before: " + annaPost);

        // When
        anna.setSocialPublisher(new SnapchatPublisher());
        annaPost = anna.sharePost();
        System.out.println("After: " + annaPost);

        // Then
        Assert.assertEquals("Snapchat is used for sharing.",annaPost);
    }

}
