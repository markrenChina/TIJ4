package ex;

import containers.Countries;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex3 {

    public static <T extends Set> void test(Class<T> clz) throws InstantiationException, IllegalAccessException {
        T set = clz.newInstance();
        set.addAll(Countries.names(10));
        set.addAll(Countries.names(10));
        set.addAll(Countries.names(10));
        set.addAll(Countries.names(10));
        set.addAll(Countries.names(10));
        System.out.println(set);
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        test(HashSet.class);
        test(LinkedHashSet.class);
        test(TreeSet.class);
    }
}
