package util;

import java.util.HashSet;
import java.util.Set;

public class Sets {
    //并集
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    //交集
    public static <T> Set<T> intersection(Set<T> a,Set<T> b){
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    //Subtract subset from superset
    public static <T> Set<T> difference(Set<T> superset,Set<T> subset){
        Set<T> result = new HashSet<>(superset);
        result.removeAll(subset);
        return result;
    }
    //交集之外的元素
    //Reflexive--everything not in the intersection
    public static <T> Set<T> complement(Set<T> a,Set<T> b) {
        return difference(union(a,b),intersection(a,b));
    }
}
