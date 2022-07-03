package ex8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ex8 {

    static void printAllParent(Object obj){
        Class parent = obj.getClass().getSuperclass();
        while (parent != null){
            System.out.println(parent.getCanonicalName());
            parent = parent.getSuperclass();
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        printAllParent(list);
        HashMap map = new HashMap<>();
        printAllParent(map);
    }
}
