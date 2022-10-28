package ex;

import java.util.LinkedList;
import java.util.ListIterator;

class MySortSet<T extends Comparable> {
    private LinkedList<T > list = new LinkedList<>();

    public synchronized void  insert(T val){
        ListIterator<T> lit = list.listIterator();
        while (lit.hasNext()){
            int bak = val.compareTo(lit.next());
            if (bak < 0){
                lit.previous();
                break;
            }else if ( bak == 0){
                return;
            }
        }
        lit.add(val);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

public class Ex10 {

    public static void main(String[] args) {
        MySortSet<Integer> sortSet = new MySortSet<>();
        sortSet.insert(2);
        sortSet.insert(3);
        sortSet.insert(1);
        System.out.println(sortSet);
    }
}
