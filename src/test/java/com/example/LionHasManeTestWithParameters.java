package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

@RunWith(Parameterized.class)
public class LionHasManeTestWithParameters {
    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private static final String ERROR_MESSAGE = "Используйте допустимые значения пола животного - самец или самка";
    private String sex;
    private boolean hasMane;

    public LionHasManeTestWithParameters(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Mock
    Feline feline;

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {MALE, true},
                {FEMALE, false},
                {" ", false},
        };
    }

    @Test
    public void lionGenderTest()  {
        try{
            Lion lion = new Lion(sex,feline);
            lion.doesHaveMane();
            Assert.assertEquals(hasMane, lion.doesHaveMane());
        } catch (Exception e){
            Assert.assertEquals(ERROR_MESSAGE, e.getMessage());
        }
    }
}