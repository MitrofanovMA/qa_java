package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlexTest {

    private Alex alex;
    private Feline feline;

    @BeforeEach
    void setUp() throws Exception {


        alex = new Alex(feline);
    }

    @Test
    void getKittens() {
        assertEquals(0, alex.getKittens());
    }

    @Test
    void getFriends() {
        List<String> myList = new ArrayList<>(List.of("Марти", "Глория", "Мелман"));
        assertEquals(myList, alex.getFriends());
    }

    @Test
    void getPlaceOfLiving() {
        String placeOfLiving = "Нью-Йоркский зоопарк";
        assertEquals(placeOfLiving, alex.getPlaceOfLiving());
    }
}