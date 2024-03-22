package com.example;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest extends TestCase {

    private int kittensCount = 5;

    @Spy
    private Feline felineSpy;

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        Animal animal = new Animal();
        assertEquals(feline.eatMeat(), animal.getFood("Хищник"));
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        feline.getFamily();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensFixedAmountTest() {
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensCustomAmountTest() {
        Feline feline = new Feline();
        feline.getKittens(kittensCount);
        assertEquals(kittensCount, feline.getKittens(5));
    }
}