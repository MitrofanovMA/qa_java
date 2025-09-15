package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CatTests {

    @Mock
    private Feline felineMock;

    @InjectMocks
    private Cat cat;

    @BeforeEach
    void setUp() {
        cat = new Cat(felineMock);
    }

    @Test
    void testGetSound() {
        String sound = cat.getSound();
         assertEquals("Мяу", sound);

    }

    @Test
    void testGetFood() throws Exception {
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
    }

}
