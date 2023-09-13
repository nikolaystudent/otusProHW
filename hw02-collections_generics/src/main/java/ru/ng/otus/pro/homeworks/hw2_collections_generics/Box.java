package ru.ng.otus.pro.homeworks.hw2_collections_generics;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit>{

    private ArrayList<T> content = new ArrayList<>();

    public void inputInBox(T... fruits){
        this.content.addAll(new ArrayList<>(Arrays.asList(fruits)));
    }

    public void inputInBox(ArrayList<? extends T> fruits){
        this.content.addAll(fruits);
    }

    public float weight(){
        float result = 0.0f;
        for (T i : content) {
            result += i.getWeight();
        }
        return result;
    }

    public boolean compare(Box<? extends Fruit> box){
        if (box == null){
            return false;
        }
        return Math.abs(this.weight() - box.weight()) < 0.0001;
    }

    public void moveContent(Box<? super T> box){
        if (box == this || box == null){
            return;
        }
        box.inputInBox(content);
        this.content.clear();
    }

}
