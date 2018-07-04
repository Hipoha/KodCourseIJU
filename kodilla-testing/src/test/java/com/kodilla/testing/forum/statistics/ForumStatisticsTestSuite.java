package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {
    @Test
    public void testCalculateAdvStatistics() {
        ForumAdvStatistics forumStatistics = new ForumAdvStatistics();

        /****** 1: Subtests for getPostsPerUser() ******/
        {// Subtest 1.1
            // Given
            Statistics statisticsMock = initializeStatisticsMock(
                    0, 1, 1);
            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            // Then
            Assert.assertEquals("Subtest 1.1",-1.0, forumStatistics.getPostsPerUser(), 0.000000001);
        }

        {// Subtest 1.2
            // Given
            Statistics statisticsMock = initializeStatisticsMock(
                    100, 0, 1);
            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            // Then
            Assert.assertEquals("Subtest 1.2",0.0, forumStatistics.getPostsPerUser(), 0.000000001);
        }

        {// Subtest 1.3
            // Given
            Statistics statisticsMock = initializeStatisticsMock(
                    100, 1000, 1);
            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            // Then
            Assert.assertEquals("Subtest 1.3",10.0, forumStatistics.getPostsPerUser(), 0.000000001);
        }

        /****** 2: Subtests for getCommentsPerUser() ******/
        {// Subtest 2.1
            // Given
            Statistics statisticsMock = initializeStatisticsMock(
                    100, 1, 0);
            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            // Then
            Assert.assertEquals("Subtest 2.1",0.0, forumStatistics.getCommentsPerUser(), 0.000000001);
        }

        {// Subtest 2.2
            // Given
            Statistics statisticsMock = initializeStatisticsMock(
                    100, 1, 1097);
            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            // Then
            Assert.assertEquals("Subtest 2.2",10.97, forumStatistics.getCommentsPerUser(), 0.000000001);
        }

        /****** 3: Subtests for getCommentsPerPost() ******/
        {// Subtest 3.1
            // Given
            Statistics statisticsMock = initializeStatisticsMock(
                    1, 0, 1);
            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            // Then
            Assert.assertEquals("Subtest 3.1",-1.0, forumStatistics.getCommentsPerPost(), 0.000000001);
        }

        {// Subtest 3.2
            // Given
            Statistics statisticsMock = initializeStatisticsMock(
                    1, 1000, 0);
            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            // Then
            Assert.assertEquals("Subtest 3.2",0.0, forumStatistics.getCommentsPerPost(), 0.000000001);
        }

        {// Subtest 3.3
            // Given
            Statistics statisticsMock = initializeStatisticsMock(
                    1, 1000, 907);
            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            // Then
            Assert.assertEquals("Subtest 3.3",0.907, forumStatistics.getCommentsPerPost(), 0.000000001);
        }

        {// Subtest 3.4
            // Given
            Statistics statisticsMock = initializeStatisticsMock(
                    1, 1000, 1097);
            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            // Then
            Assert.assertEquals("Subtest 3.4",1.097, forumStatistics.getCommentsPerPost(), 0.000000001);
        }
    }

    public Statistics initializeStatisticsMock(int numberOfUsers, int numberOfPosts, int numberOfComments) {
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesMock = new ArrayList<String>();
        for (int i = 0; i < numberOfUsers; i++) {
            userNamesMock.add("User " + (i + 1));
        }
        when(statisticsMock.usersNames()).thenReturn(userNamesMock);
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        return statisticsMock;
    }

}
