package ex;

import java.util.*;
import java.util.stream.Collectors;


class SimpleHashMap6<K, V> extends AbstractMap<K,V> {

    MapEntry<K, V>[] buckets = new MapEntry[100];

    MapEntry<K, V> head = null;

    public V put(K key, V value) {
        V oldValue = null;
        boolean found = false;
        int index = Math.abs(key.hashCode()) % 100;

        if (buckets[index] == null) {
            buckets[index] = new MapEntry<>(key, value, null);
        } else {
            MapEntry<K, V> bucket = buckets[index];
            //MapEntry<K,V> pair = new MapEntry(key, value);
            while (bucket.next != null) {
                //todo 链接单链表
                MapEntry<K, V> iPair = bucket.next;
                if (iPair.getKey().equals(key)) {
                    oldValue = iPair.getValue();
                    iPair.value = value; //Replace old with new
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            buckets[index].next = new MapEntry<>(key, value);
            if (head == null) {
                head = buckets[index];
            }
        }
        return oldValue;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return Arrays.stream(buckets).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return super.toString();
    }

    class MapEntry<K, V>implements Map.Entry<K,V>  {
        K key;
        V value;
        MapEntry<K, V> next = null;

        public MapEntry(K key, V value, MapEntry<K, V> next) {
            this(key, value);
            this.next = next;
        }

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public MapEntry<K, V> getNext() {
            return next;
        }

        public void setNext(MapEntry<K, V> next) {
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return this.value = value;
        }
    }
}

public class Ex25 {

    public static void main(String[] args) {
        SimpleHashMap6<Integer, String> sm = new SimpleHashMap6<>();
        sm.put(1, "1");
        sm.put(2, "2");
        sm.put(3, "3");
        sm.put(4, "4");
        System.out.println(sm);
    }
}

