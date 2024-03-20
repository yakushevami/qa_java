package com.example;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest extends TestCase {
    private final String expectedFamily = "Кошачьи";
    private static final int EXPECTED_KITTENS_COUNT_FOR_MOCK = 1;
    private int kittensCount = 5;

    @Spy
    private Feline feline;

    @Test
    public void isCarnivoreTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyTest() {
        String actual = feline.getFamily();
        assertEquals("Семейство не соответствует ожидаемому", expectedFamily, actual);
    }

    @Test
    public void getKittensFixedAmountTest() {
        int actual = feline.getKittens();
        assertEquals("Количество котят не соответствует ожидаемому", EXPECTED_KITTENS_COUNT_FOR_MOCK, actual);
    }

    @Test
    public void getKittensCustomAmountTest() {
        int actual = feline.getKittens(kittensCount);
        assertEquals("Количество котят не соответствует ожидаемому", kittensCount, actual);
    }
}