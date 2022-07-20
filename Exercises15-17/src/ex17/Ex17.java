package ex17;

import watercolors.Watercolors;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static watercolors.Watercolors.*;

public class Ex17 {
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        try {
            if(a instanceof EnumSet ) {
                Set<T> result = (Set<T>) ((EnumSet)a).clone();
                result.addAll(b);
                return result;
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        Set<T> result = new HashSet<T>(a);
        result.addAll(b);
        return result;
    }
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        try {
            if(a instanceof EnumSet) {
                Set<T> result = (Set<T>) ((EnumSet)a).clone();
                result.retainAll(b);
                return result;
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }
    // Subtract subset from superset:
    public static <T> Set<T>  difference(Set<T> superset, Set<T> subset) {
        try {
            if(superset instanceof EnumSet) {
                Set<T> result = (Set<T>) ((EnumSet)superset).clone();
                result.removeAll(subset);
                return result;
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        Set<T> result = new HashSet<T>(superset);
        result.removeAll(subset);
        return result;
    }
    // Reflexive--everything not in the intersection:
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }
    public static void main(String[] args) {
        Set<Watercolors> set1 =
                EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 =
                EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("union(set1, set2): " + union(set1, set2));
        Set<Watercolors> subset = intersection(set1, set2);
        System.out.println("intersection(set1, set2): " + subset);
        System.out.println("difference(set1, set2): " +
                difference(set1, set2));
        System.out.println("difference(set2, subset): " +
                difference(set2, subset));
        System.out.println("complement(set1, set2): " +
                complement(set1, set2));
    }
}
