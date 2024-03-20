package com.example;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class CatTest {
    Feline feline = new Feline();
    Cat cat = new Cat(feline);
    @Test
    public void getCatSoundTest() {
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals("Несоответствующий звук", expectedSound, actualSound);
    }

    @Test
    public void getCatFoodTest() throws Exception {
        List<String> expectedEatMeat = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualEatMeat = cat.getFood();
        assertEquals("Несоответствующая еда", expectedEatMeat, actualEatMeat);
    }

}