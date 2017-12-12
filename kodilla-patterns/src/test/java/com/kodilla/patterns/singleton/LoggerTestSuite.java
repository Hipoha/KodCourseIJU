package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetFileName() {
        //Given
        Logger.getInstance();
        //When
        Logger.getInstance().log("Log record 1");
        Logger.getInstance().log("Log record 2");
        //Then
        Assert.assertEquals("Log record 2", Logger.getInstance().getLastLog());
    }

}
