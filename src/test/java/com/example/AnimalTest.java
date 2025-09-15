package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class AnimalTests {

    @Mock
    private Feline felineMock;

    @Mock
    private Predator predatorMock;

    private Animal animal;

    @BeforeEach
    void setUp() {
        animal = new Animal();
    }

    @Test
    void testGetFood_herbivore() throws Exception {
        List<String> expected = List.of("Трава", "Различные растения");
        List<String> result = animal.getFood("Травоядное");

        assertEquals(expected, result);
        assertEquals(2, result.size());
    }

    @Test
    void testGetFood_predator() throws Exception {

        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> result = animal.getFood("Хищник");

        assertEquals(expected, result);
        assertEquals(3, result.size());
    }

    @Test
    void testGetFood_unknownType() {

       assertThrows(Exception.class, () -> {
            animal.getFood("Неизвестный тип");
        });
    }

    @Test
    void testGetFamily() {

        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String result = animal.getFamily();

        assertEquals(expected, result);
    }
}