package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class LionTests {

    @Mock
    private Feline felineMock;

    private Lion lion;

    @BeforeEach
    void setUp() throws Exception {
        lion = new Lion("Самец", felineMock);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void testConstructor(String sex) throws Exception {
        Lion lion = new Lion(sex, felineMock);

        boolean expectedHasMane = "Самец".equals(sex);

        assertEquals(expectedHasMane, lion.doesHaveMane());
    }


    @Test
    void testGetKittens() {
        int expectedKittens = 3;

        Mockito.when(felineMock.getKittens())
                .thenReturn(expectedKittens);

        int actualKittens = lion.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }


    @Test
    void testGetFood() throws Exception {

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(felineMock.getFood("Хищник"))
                .thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood,
                "Списки продуктов питания должны совпадать");
    }

    @Test
    void testInvalidSex() {

        String expectedMessage = "Используйте допустимые значения пола животного - самей или самка";
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("животное", felineMock);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

}
