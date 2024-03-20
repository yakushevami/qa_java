package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {
    private final String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    private final List<String> expectedFood = List.of("Трава", "Различные растения");

    @Spy
    Animal animal;

    @Test
    public void isFamilyListCorrectTest(){
        String actual = animal.getFamily();
        assertEquals("Несоответствующая семья", expectedFamily, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> actual = animal.getFood("Травоядное");
        assertEquals("Несоответствующий тип еды", expectedFood, actual);
    }

    @Test
    public void getFoodExceptionTest() {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            Animal animal = new Animal();
            animal.getFood(" ");
        });
        String expectedResult = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        assertEquals(expectedResult, exception.getMessage());
    }
}
