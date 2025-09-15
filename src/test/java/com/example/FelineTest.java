package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

class FelineTests {

    private Feline feline;

    @BeforeEach
    void setUp() {
        feline = new Feline();
    }

    @Test
    void testGetFamily() {
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }


    @Test
    void getKittens(){
        assertEquals(1, feline.getKittens());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testGetKittens(int kittensCount) {
        int result = feline.getKittens(kittensCount);
        assertEquals(kittensCount, result);
    }


    @Test
    void testEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood);
    }

}
