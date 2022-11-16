package ex;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex18<E> extends AbstractSet<E> {
    private List<E> values = new ArrayList<>();

    @Override
    public boolean add(E e) {
        if (!values.contains(e)){
            values.add(e);
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = -1;
            @Override
            public boolean hasNext() {
                return index < values.size()-1;
            }

            @Override
            public E next() {
                return values.get(++index);
            }
        };
    }

    @Override
    public int size() {
        return values.size();
    }

    //...
}
