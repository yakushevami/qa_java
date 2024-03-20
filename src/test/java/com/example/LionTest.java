package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void getLionGenderExceptionTest() {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            Lion lion = new Lion(" ", feline);
        });
        String expectedResult = "Используйте допустимые значения пола животного - самец или самка";
        assertEquals(expectedResult, exception.getMessage());
    }

    @Test
    public void getLionGenderTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expectedHasMane = true;
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals("Несоответствующий пол", expectedHasMane, actualHasMane);
    }

    @Test
    public void getLionFoodTypeTest() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Несоответствующий тип еды", expectedResult, lion.getFood());
    }

    @Test
    public void getLionDoNotHaveKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedGetKittens = 0;
        int actualGetKittens = lion.getKittens();
        assertEquals("Несоответствуеющее количество котят", expectedGetKittens, actualGetKittens);
    }
}