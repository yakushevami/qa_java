package com.example;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest extends TestCase {

    private int kittensCount = 5;

    @Spy
    private Feline feline;

    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyTest() {
        feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();
    }

    @Test
    public void getKittensFixedAmountTest() {
        feline.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void getKittensCustomAmountTest() {
        feline.getKittens(kittensCount);
        Mockito.verify(feline).getKittens(Mockito.anyInt());
    }
}