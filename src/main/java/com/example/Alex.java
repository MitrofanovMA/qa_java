package com.example;

import java.util.ArrayList;
import java.util.List;

public class Alex extends Lion{

    private List<String> friends;
    private String placeOfLiving = "Нью-Йоркский зоопарк";

    private Feline feline;

    public Alex(Feline feline) throws Exception {
        super("Самец", feline);

        friends = new ArrayList<>();
        friends.add("Марти");
        friends.add("Глория");
        friends.add("Мелман");
    }

    @Override
    public int getKittens() {
        return 0;
    }

    public List<String> getFriends(){
    return friends;
    }

    public String getPlaceOfLiving(){
    return placeOfLiving;
    }

}
