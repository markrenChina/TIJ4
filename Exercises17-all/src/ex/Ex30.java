package ex;

import containers.Test;
import containers.TestParam;
import containers.Tester;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Ex30 {

    static Random rand = new Random();
    static int reps = 1000;

    static List<Test<List<Integer>>> tests = new ArrayList<>();
    static List<Integer>  staticIntegerList = new ArrayList<>(10000);

    static {
        for (int i = 0; i < 10000; i++) {
            staticIntegerList.add(rand.nextInt());
        }

        tests.add(new Test<List<Integer>>("sort") {
            @Override
            public int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(staticIntegerList.subList(0,listSize));
                    list.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1.compareTo(o2);
                        }
                    });
                }
                return loops;
            }
        });
    }

    public static void main(String[] args) {
        Tester.defaultParams = TestParam.array(
                10, 5000,100,5000,1000,1000,10000,200
        );

        Tester<List<Integer>> arrayTest = new Tester<>(new ArrayList<>(),tests);
        Tester<List<Integer>> linkedTest = new Tester<>(new ArrayList<>(),tests);
        arrayTest.timedTest();
        linkedTest.timedTest();
    }
}
