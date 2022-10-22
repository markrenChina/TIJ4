package ex;

import java.util.Iterator;

class SList<T>{
    private final T value;
    private SList<T> next;

    public SList(T value) {
        this.value = value;
    }

    public SListIterator iterator() {
        return new SListIterator(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(value);
        SList<T> tmp = next;
        while (tmp!= null){
            sb.append(" ").append(tmp.value);
            tmp = tmp.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public class SListIterator implements Iterator<T> {
        private SList<T> current;

        public SListIterator(SList<T> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            current = current.next;
            return current.value;
        }

        //remove next node
        @Override
        public void remove() {
            if (hasNext()){
                current.next = current.next.next;
            }
        }

        public void insert(T v){
            SList<T> next = new SList<>(v);
            if (hasNext()){
                next.next = current.next;
            }
            current.next = next;
        }
    }
}

public class Ex8 {

    public static void main(String[] args) {
        SList<String> s1 = new SList<>("A");
        System.out.println(s1);
        SList<String>.SListIterator iterator = s1.iterator();
        iterator.insert("B");
        System.out.println(s1);
        iterator.remove();
        System.out.println(s1);
    }
}
