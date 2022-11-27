package ex;

import containers.Test;
import containers.TestParam;
import containers.Tester;
import net.mindview.util.CountingGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class SimpleStringArray {
    private String[] data;
    private int size;
    private int capacity;

    public SimpleStringArray() {
        data = new String[8];
        capacity = 8;
        size = 0;
    }

    public SimpleStringArray(int capacity) {
        data = new String[capacity];
        this.capacity = capacity;
    }

    private synchronized void grow(){
        capacity = capacity * 2;
        data = Arrays.copyOf(data,capacity);
    }

    public void add(String val){
        if (size == capacity){
            grow();
        }
        data[size] = val;
        size++;
    }


    public String get(int index){
        if (index < size){
            return data[index];
        }else {
            throw new ArrayIndexOutOfBoundsException("size = " + size + " index =" + index);
        }
    }

    public void clear(){
        data = new String[8];
        capacity = 8;
        size = 0;
    }
}

public class Ex31 {

    private static List<Test<SimpleStringArray>> tests1 = new ArrayList<>();
    private static List<Test<ArrayList<String>>> tests2 = new ArrayList<>();

    //private static Generator<String> generator = new CountingGenerator.String(2);
    private static List<String> staticStringList = new ArrayList<>(10000);

    static {
        for (int i = 0; i < 10000; i++) {
            staticStringList.add(new CountingGenerator.String(  ThreadLocalRandom.current().nextInt(100)).next());
        }
        tests1.add(new Test<SimpleStringArray>("add") {
            @Override
            public int test(SimpleStringArray container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++) {
                        container.add(staticStringList.get(j));
                    }
                }
                return loops *size;
            }
        });
        tests1.add(new Test<SimpleStringArray>("get") {
            @Override
            public int test(SimpleStringArray container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < size; j++) {
                        container.get(j);
                    }
                }
                return loops *size;
            }
        });
        tests2.add(new Test<ArrayList<String>>("add") {
            @Override
            public int test(ArrayList<String> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++) {
                        container.add(staticStringList.get(j));
                    }
                }
                return loops *size;
            }
        });
        tests2.add(new Test<ArrayList<String>>("get") {
            @Override
            public int test(ArrayList<String> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < size; j++) {
                        container.get(j);
                    }
                }
                return loops *size;
            }
        });
    }

    public static void main(String[] args) {
        Tester<SimpleStringArray> sTester  = new Tester<>(new SimpleStringArray(),tests1){
            @Override
            protected SimpleStringArray initialize(int size) {
                for (int i = 0; i < size; i++) {
                    container.add(staticStringList.get(i));
                }
                return container;
            }
        };
        Tester<ArrayList<String>> aTester  = new Tester<>(new ArrayList<String>(),tests2){
            @Override
            protected ArrayList<String> initialize(int size) {
                for (int i = 0; i < size; i++) {
                    container.add(staticStringList.get(i));
                }
                return container;
            }
        };

        sTester.timedTest(); //预热
        sTester.timedTest();
        aTester.timedTest(); //预热
        aTester.timedTest();
    }
}
