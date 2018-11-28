package Lesson_1;

import javafx.fxml.Initializable;

public class Stats<T extends Number> {

    private T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }

    public double avg() {
        double sum = 0.0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    public boolean sameAvg(Stats<? super Double> another) {
        return Math.abs(this.avg() - another.avg()) < 0.0001;
    }
}


class MainStats {
    public static void main(String[] args) {
        Integer[] inums = {1,2,3,4,5};
        Double[] dnums = {1.0, 2.0, 3.0, 4.0, 5.0};

        Stats<Integer> iob = new Stats<Integer>(inums);
        Stats<Double> dob = new Stats<Double>(dnums);

        if(iob.sameAvg(dob)) {
            System.out.println("средние значения равны!");
        } else {
            System.out.println("средние значения не равны!");
        }
//        double res = iob.avg();
//
//        System.out.println(res);
//
//
//        Stats<Double> dob = new Stats<Double>(dnums);
//        double res1 = dob.avg();
//
//        System.out.println(res1);

//        String[] strMass = {"str1", "str2", "str3"};
//        Stats<String> strO = new Stats<String>(strMass);

    }
}
