package ex29;

import generics.Holder;

import java.util.ArrayList;
import java.util.List;

public class Ex29 {
    static void f1(Holder<List<?>> holder){
        List<?> list = holder.get();
        System.out.println(list.get(0).getClass().getSimpleName());
        f5(holder);
    }

    static void f3(Holder<? extends List> holder){
        List list = holder.get();
        System.out.println(list.get(0).getClass().getSimpleName());
    }

    static void f2(Holder<?> holder){
        Object obj = holder.get();
        System.out.println(obj.getClass().getSimpleName());
    }

    static <T> void f4(Holder<? extends List<T>> holder){
        List<T> list = holder.get();
        System.out.println(list.get(0).getClass().getSimpleName());
    }

    static <T> void f5(Holder<T> holder){
        T obj = holder.get();
        System.out.println("f5 " + obj.getClass().getSimpleName());
        //if (obj instanceof List){
            f6((List<?>) obj);
        //}
    }

    static void f6(List<?> list){
        System.out.println("f6");
        f7(list);
    }

    static <T> void f7(List<T> list){
        T t = list.get(0);
        System.out.println("f7 " + t.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(new Integer(1));
        Holder<List<?>> holder = new Holder<>(list);
        f1(holder);
        f2(holder);
        f3(holder);
        Holder<List<Integer>> holderInt = new Holder<>(list);
        f4(holderInt);
        f5(holder);
        f5(holderInt);
    }
}
