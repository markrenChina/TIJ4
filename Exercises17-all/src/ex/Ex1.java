package ex;

import containers.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>(Countries.names(8));
        Collections.sort(a);
        System.out.println(a);
        Collections.shuffle(a);
        System.out.println(a);

        List<String> b = new LinkedList<>(Countries.names(8));
        Collections.sort(b);
        System.out.println(b);
        Collections.shuffle(b);
        System.out.println(b);
    }
}
