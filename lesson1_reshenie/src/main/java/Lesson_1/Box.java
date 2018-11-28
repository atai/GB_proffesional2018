package Lesson_1;

public class Box {

    private Object obj;

    public Box(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void info() {
        System.out.println("obj " + obj);
        System.out.println("type " + obj.getClass());
    }
}

class BoxInt {
    private Integer obj;

    public BoxInt(Integer obj) {
        this.obj = obj;
    }

    public Integer getObj() {
        return obj;
    }

    public void setObj(Integer obj) {
        this.obj = obj;
    }

    public void info() {
        System.out.println("obj " + obj);
        System.out.println("type " + obj.getClass());
    }
}

class Main {
    public static void main(String[] args) {
//        Box box1 = new Box(1);
//        BoxInt box2 = new BoxInt(10);
//
//        box1.info();
//        box2.info();
//
//        int x = 10;
//        x = x + (Integer) box1.getObj();
//        System.out.println(x);
//
//        x = x + (Integer) box2.getObj();
//        System.out.println(x);

//        BoxUltimate<String> wSt = new BoxUltimate<String>("Hello");
////        BoxUltimate<Integer> wInt = new BoxUltimate<Integer>(20);
////
////         wSt.info();
////         wInt.info();
////
////        int x = 10;
////        x = x + wInt.getObj();
        BoxUltimate<Integer, String> twoGen = new BoxUltimate<Integer, String>(555, "Hello");
        twoGen.info();

        int value = twoGen.getObj1();
        String str = twoGen.getObj2();

        System.out.println(value + " " + str);
    }
}
