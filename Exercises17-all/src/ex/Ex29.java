package ex;

import containers.Test;
import containers.TestParam;
import containers.Tester;
import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.util.*;

public class Ex29 {

    static Random rand = new Random();
    static int reps = 1000;

    static List<Test<List<String>>> tests = new ArrayList<>();
    static List<Test<LinkedList<String>>> qTests = new ArrayList<>();

    static Generator<String> generator = new CountingGenerator.String(2);
    static List<String> staticStringList = new ArrayList<>(10000);

    static {
        for (int i = 0; i < 10000; i++) {
            staticStringList.add(generator.next());
        }
        tests.add(new Test<List<String>>("add") {
            @Override
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int i1 = 0; i1 < listSize; i1++) {
                        list.add("i1");
                    }
                }
                return loops * listSize;
            }
        });

        tests.add(new Test<List<String>>("get") {
            @Override
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++) {
                    list.get(rand.nextInt(listSize));
                }
                return loops;
            }
        });

        tests.add(new Test<List<String>>("set") {
            @Override
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++) {
                    list.set(rand.nextInt(listSize),"47");
                }
                return loops;
            }
        });

        tests.add(new Test<List<String>>("iteradd") {
            @Override
            public int test(List<String> list, TestParam tp) {
                final int LOOPS = 1_000_000;
                int half = list.size() >> 1;
                ListIterator<String> it = list.listIterator(half);
                for (int i = 0; i < LOOPS; i++) {
                    it.add("47");
                }
                return LOOPS;
            }
        });

        tests.add(new Test<List<String>>("insert") {
            @Override
            public int test(List<String> list, TestParam tp) {
                for (int i = 0; i < tp.loops; i++) {
                    list.add(5,"47");
                }
                return tp.loops;
            }
        });

        tests.add(new Test<List<String>>("remove") {
            @Override
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(staticStringList.subList(0,size));
                    while (list.size() > 5){
                        list.remove(5);
                    }
                }
                return loops * size;
            }
        });

        //Tests for queue behavior
        qTests.add(new Test<LinkedList<String>>("addFirst") {
            @Override
            public int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++) {
                        list.addFirst("47");
                    }
                }
                return loops * size;
            }
        });

        qTests.add(new Test<LinkedList<String>>("addLast") {
            @Override
            public int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j <size; j++) {
                        list.addLast("47");
                    }
                }
                return loops * size;
            }
        });

        qTests.add(new Test<LinkedList<String>>("rmFirst") {
            @Override
            public int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(staticStringList.subList(0,size));
                    while (list.size() > 0){
                        list.removeFirst();
                    }
                }
                return loops * size;
            }
        });

        qTests.add(new Test<LinkedList<String>>("rmLast") {
            @Override
            public int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(staticStringList.subList(0,size));
                    while (list.size() > 0){
                        list.removeLast();
                    }
                }
                return loops * size;
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0){
            Tester.defaultParams = TestParam.array(args);
        }
        //Can only do these two tests on an array
        Tester<List<String>> arrayTest = new Tester<>(null,tests.subList(1,3)){
            //This will be called before each test . It
            //produces a non-resizeable array-backed list

            @Override
            protected List<String> initialize(int size) {
                String[] ia = Generated.array(String.class,
                        new CountingGenerator.String(),size);
                return Arrays.asList(ia);
            }
        };

        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();
        Tester.defaultParams = TestParam.array(
                10, 5000,100,5000,1000,1000,10000,200
        );
        if (args.length > 0){
            Tester.defaultParams = TestParam.array(args);
        }
        ListTester.run(new ArrayList<>(),tests);
        ListTester.run(new LinkedList<>(),tests);
        ListTester.run(new Vector<>(),tests);

        Tester.fieldWidth = 12;
        Tester<LinkedList<String>> qTest = new Tester<>(new LinkedList<>(), qTests);
        qTest.setHeadline("Queue tests");
        qTest.timedTest();
    }

    static class ListTester extends Tester<List<String>> {

        public ListTester(List<String> container, List<Test<List<String>>> tests) {
            super(container, tests);
        }

        //Convenience method
        public static void run(List<String> list,List<Test<List<String>>> tests) {
            new ListTester(list,tests).timedTest();
        }

        //Fill to the appropriate size before each test
        @Override
        protected List<String> initialize(int size) {
            container.clear();
            container.addAll(staticStringList.subList(0,size));
            return container;
        }
    }
}
