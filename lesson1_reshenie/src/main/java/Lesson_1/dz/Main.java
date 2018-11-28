package Lesson_1.dz;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Box<Fruit> box = new Box<>();
        Box<Apple> boxa = new Box<>();
        boxa.addFruit(new Apple());
        boxa.transfer(box);
    }

    public static void swap(Object[] arr, int x1, int x2) {
        Object temp = arr[x1];
        arr[x1] = arr[x2];
        arr[x2] = temp;
    }

    public static <T> ArrayList<T> convert(T[] arr) {
        return new ArrayList<T>(Arrays.asList(arr));
    }
}


class Box<T extends Fruit> {
    private ArrayList<T> list;

    public Box(T... arr) {
        list = new ArrayList<T>(Arrays.asList(arr));
    }

    public float getWeight() {
        if (list.size() == 0) return 0.0f;
        return list.get(0).getWeight() * list.size();
    }

    public void addFruit(T fruit) {
        list.add(fruit);
    }

    public boolean compare(Box another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.00001;
    }

    public void transfer(Box<? super T> another) {
        another.list.addAll(this.list);
        this.list.clear();
    }
}


abstract class Fruit {
    protected float weight;

    public abstract Fruit newInstance();

    public float getWeight() {
        return weight;
    }

    public Fruit(float weight) {
        this.weight = weight;
    }
}


class Orange extends Fruit {
    public Orange() {
        super(1.5f);
    }

    @Override
    public Fruit newInstance() {
        return new Orange();
    }
}


class Apple extends Fruit {
    public Apple() {
        super(1.0f);
    }

    @Override
    public Fruit newInstance() {
        return new Apple();
    }
}


































//
//    public void pour(Box to){
//        if(this.BoxType==to.BoxType){
//            Collections.addAll( to.content, this.content);
//            this.content.clear();
//        }
//        else{
//            System.out.println("несовместимые типы");
//        }
//
//
//
//
//
//////////////////////////////////
//
//
//
//        public void replace(Box b2) {
//            if (this.fruitInBox.type.equals(b2.fruitInBox.type)) {
//
//
//
//
//
//////////////////////////////
//
//
//                public void moveToBox(Box<T> box) {
//                    while (this.fruits.size() > 0) {
//                        box.addFruit(this.fruits.remove(0));
//                    }
//                }
//
//
//
//                ////////////////////
//
//
//                void intersperseFruits(Box<T> anotherBox) {
//                    while (box.size() > 0) {
//                        anotherBox.addFruit(box.get(0));
//                        box.remove(0);
//                    }
//                }
//
//
//                //////////////////
//
//
//                // не нужно везде использовать T
//                private void swapElements(T[] array, int index1, int index2) {
//                    T buffer = array[index1];
//                    array[index1] = array[index2];
//                    array[index2] = buffer;
//                }
//
//                private static <T> void swap(T[] a, int i, int j) {
//                    T tmp = a[i];
//                    a[i] = a[j];
//                    a[j] = tmp;
//                }
//
//
//                private static  <T> void swapTwoElementsInArray(T[] array, int firstNumPos, int secondNumPos) throws WrongPositionException {
//                    if (firstNumPos < 0 || firstNumPos > array.length ||
//                            secondNumPos < 0 || secondNumPos > array.length || firstNumPos == secondNumPos) {
//                        throw new WrongPositionException("Wrong element's positions");
//                    }
//                    T temp = array[firstNumPos];
//                    array[firstNumPos] = array[secondNumPos];
//                    array[secondNumPos] = temp;
//                }
//
//
//
//                ///////////////////
//