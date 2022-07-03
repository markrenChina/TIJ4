package ex9;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ex9 {
    static void printAllParent(Object obj){
        Class parent = obj.getClass().getSuperclass();
        while (parent != null){
            System.out.println(parent.getCanonicalName());
            parent = parent.getSuperclass();
        }
    }

    static void printAllFields(Object obj){
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields){
            System.out.println(f.getName());
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        printAllFields(list);
        HashMap map = new HashMap<>();
        printAllFields(map);
    }
}
