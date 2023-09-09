package ru.ng.otus.pro.homeworks.hw2_collections_generics;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit>{

    private ArrayList<T> content = new ArrayList<>();

    public void inputInBox(T... fruits){
        this.content.addAll(new ArrayList<>(Arrays.asList(fruits)));
    }

    public void inputInBox(ArrayList<T> fruits){
        this.content.addAll(fruits);
    }

    public float weight(){
        float result = 0.0f;
        for (T i : content) {
            result = result + i.getWeight();
        }
        return result;
    }

    public boolean compare(Box<? extends Fruit> box){
        return Math.abs(this.weight() - box.weight()) < 0.0001;
    }

    public void moveContent(Box<T> box){
        box.inputInBox(content);
        this.content.clear();
    }

}
