package Lesson_1;

public class BoxUltimate<T, V> {
    private T obj1;
    private V obj2;

    public BoxUltimate(T obj1, V obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public T getObj1() {
        return obj1;
    }

    public void setObj1(T obj1) {
        this.obj1 = obj1;
    }

    public V getObj2() {
        return obj2;
    }

    public void setObj2(V obj2) {
        this.obj2 = obj2;
    }

    public void info() {
        System.out.println("type T " + obj1.getClass().getName());
        System.out.println("type V " + obj2.getClass().getName());

    }
}
