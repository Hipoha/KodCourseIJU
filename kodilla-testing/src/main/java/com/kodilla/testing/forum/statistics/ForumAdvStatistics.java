package com.kodilla.testing.forum.statistics;

public class ForumAdvStatistics {
    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private double postsPerUser;
    private double commentsPerUser;
    private double commentsPerPost;

    // Using default constructor


    public void calculateAdvStatistics(Statistics statistics) {
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();
        postsPerUser = numberOfUsers == 0 ? -1.0 : (double)numberOfPosts / (double)numberOfUsers;
        commentsPerUser = numberOfUsers == 0 ? -1.0 : (double)numberOfComments / (double)numberOfUsers;
        commentsPerPost = numberOfPosts == 0 ? -1.0 : (double)numberOfComments / (double)numberOfPosts;
    }

    public void showStatistics() {
        System.out.println("--- FORUM STATISTICS ---");
        System.out.println("Total number of forum users: " + numberOfUsers);
        System.out.println("Total number of posts: " + numberOfPosts);
        System.out.println("Total number of comments: " + numberOfComments);
        System.out.println("Average number of posts per user: " + postsPerUser);
        System.out.println("Average number of comments per user: " + commentsPerUser);
        System.out.println("Average number of comments per post: " + commentsPerPost);
    }

    // Getters

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getPostsPerUser() {
        return postsPerUser;
    }

    public double getCommentsPerUser() {
        return commentsPerUser;
    }

    public double getCommentsPerPost() {
        return commentsPerPost;
    }
}
