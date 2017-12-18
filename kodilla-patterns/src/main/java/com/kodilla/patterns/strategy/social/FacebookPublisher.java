package com.kodilla.patterns.strategy.social;

public class FacebookPublisher implements SocialPublisher {

    public String share() {
        return "Facebook is used for sharing.";
    }

}
