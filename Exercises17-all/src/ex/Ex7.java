package ex;

import containers.Countries;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Ex7 {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(Countries.names(25));
        List<String> list2 = new ArrayList<>(Countries.names(25));
        Iterator<String> it1 = list1.iterator();
        Iterator<String> it2 = list2.iterator();
        while (it1.hasNext()){
            System.out.print(it1.next() + " ");
        }
        System.out.println();
        while (it2.hasNext()){
            System.out.print(it2.next() + " ");
        }
        System.out.println();
        ListIterator<String> lit1 = list1.listIterator(list1.size() );
        ListIterator<String> lit2 = list2.listIterator();
        while (lit1.hasPrevious() && lit2.hasNext()) {
            lit1.previous();
            lit1.add(lit2.next());
            lit1.previous();
        }
        while (lit2.hasNext()){
            lit1.add(lit2.next());
        }
        System.out.println(list1);
    }
}
