package ex13;

import net.mindview.util.Generator;

import java.util.*;

public class Ex13 {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n){
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static <T> List<T> fill(List<T> coll, Generator<T> gen, int n){
        System.out.println("List");
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static <T> List<T> fill(LinkedList<T> coll, Generator<T> gen, int n){
        System.out.println("LinkedList");
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static <T> Queue<T> fill(Queue<T> coll, Generator<T> gen, int n){
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static <T> Set<T> fill(Set<T> coll, Generator<T> gen, int n){
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        List<Integer> list = fill(new LinkedList<>(), new Generator<Integer>() {
            @Override
            public Integer next() {
                return (int) (System.currentTimeMillis() % 100);
            }
        },10);
        List<Integer> list2 = fill(new ArrayList<>(), new Generator<Integer>() {
            @Override
            public Integer next() {
                return (int) (System.currentTimeMillis() % 100);
            }
        },10);
    }
}
