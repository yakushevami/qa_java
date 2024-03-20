package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {
   //@Mock
    private Feline feline;
    private LionAlex lionAlex;
    private final int expectedKittens = 0;
    private final List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
    private final String expectedPlace = "Нью-Йоркский зоопарк";

    @Test
    public void testGetKittens() throws Exception {
        lionAlex = new LionAlex(feline);
        int actual = lionAlex.getKittens();

        assertEquals("Несоответствующее количество львят",
                expectedKittens, actual);
    }

    @Test
    public void testGetFriends() throws Exception {
        lionAlex = new LionAlex(feline);
        List<String> actual = lionAlex.getFriends();

        assertEquals("Несоответствующий список друзей",
                expectedFriends, actual);
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {
        lionAlex = new LionAlex(feline);
        String actual = lionAlex.getHomeLocation();

        assertEquals("Некорректное место проживания льва",
                expectedPlace, actual);
    }
}