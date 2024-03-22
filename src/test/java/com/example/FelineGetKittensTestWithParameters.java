package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineGetKittensTestWithParameters {

    private final int expected;

    public FelineGetKittensTestWithParameters(int expected) {
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getDataForKittens() {
        return new Object[][]{
                {5},
                {9},
                {11},
                {15},
        };
    }

    @Test
    public void testKittensArgumentTest() {
        Feline feline = new Feline();
        int actual = feline.getKittens(expected);
        Assert.assertEquals(expected, actual);
    }
}