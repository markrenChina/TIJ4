package ex;

import java.util.*;

public class Ex5 extends AbstractMap<Integer,String> {
    private static String[] chars = ("A B C D E F G H I J K L M N "+
            "O P Q R S T U V W X Y Z").split(" ");
    private int size;

    public Ex5(int size) {
        if (size < 0) {
            this.size = 0;
        }
        this.size = size;
    }

    public static void main(String[] args) {
        System.out.println(new Ex5(60));
    }

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        //LinkedHashSet retains initialization order
        Set<Map.Entry<Integer,String>> entries = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) {
            entries.add(new Entry(i));
        }
        return entries;
    }

    private static class Entry implements Map.Entry<Integer,String> {
        int index;

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            return Integer.valueOf(index).equals(o);
        }

        @Override
        public int hashCode() {
            return Objects.hash(index);
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index % chars.length]
                    + Integer.toString(index / chars.length);
        }

        @Override
        public String setValue(String value) {
            throw  new UnsupportedOperationException();
        }
    }

    static class EntrySet extends AbstractSet<Map.Entry<Integer,String>> {
        private int size;

        public EntrySet(int size) {
            this.size = Math.max(size,0);
        }

        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Iter();
        }

        @Override
        public int size() {
            return size;
        }

        private class Iter implements Iterator<Map.Entry<Integer,String>> {
            private Entry entry = new Entry(-1);
            @Override
            public boolean hasNext() {
                return entry.index < size -1;
            }

            @Override
            public Map.Entry<Integer, String> next() {
                entry.index++;
                return entry;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }
    }
}
