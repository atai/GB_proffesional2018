/*
 * Copyright (c) 2018 Rustam Atai
 */

package com.company;

import java.util.ArrayList;

public class FruitBox<T [Fruit]> {

    private double weight=0.0;
    ArrayList <T> fruitInBox;

    public <T> void add(T fruit) {
        weight = weight + fruit.getWight();
        fruitInBox.add(fruit);
    }
}
