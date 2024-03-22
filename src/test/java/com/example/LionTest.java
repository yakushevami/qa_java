package com.example;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.junit.Assert;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest{
    @Mock
    Feline feline;

    @Test
    public void lionFoodIsMeatTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(feline.getKittens(), lion.getKittens());
    }

    @Test
    public void getLionGenderExceptionTest() {
        String expectedString = "Используйте допустимые значения пола животного - самец или самка";
        Exception exception = Assert.assertThrows(Exception.class, () -> new Lion(" ", feline));
        Assert.assertEquals(expectedString, exception.getMessage());
    }
}