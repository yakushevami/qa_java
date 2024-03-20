package com.example;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
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

    @Before
    public void setUp() {
        Feline feline = new Feline();
    }

    @Test
    public void lionFoodIsMeatTest() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedResult, lion.getFood());
    }

    @Test
    public void incorrectLionGenderTest() throws Exception   {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            Lion lion = new Lion(" ", feline);
        });
        String expectedResult = "Используйте допустимые значения пола животного - самец или самка";
        assertEquals(expectedResult, exception.getMessage());
    }

    @Test
    public void femaleLionGenderTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void maleLionGenderTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        int expectedResult = 1;
        assertEquals(expectedResult, lion.getKittens());
    }
}