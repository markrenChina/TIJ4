package ex;

import containers.MapEntry;
import containers.Maps;
import containers.SlowMap;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class SlowMap2<K,V> extends SlowMap<K,V>{
    private EntrySet entries = new EntrySet();

    @Override
    public Set<Entry<K, V>> entrySet() { return entries; }

    private class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        @Override public int size() { return  keys.size(); }

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {
                private int index = -1;
                @Override
                public boolean hasNext() {
                    return index < keys.size() -1;
                }
                @Override
                public Entry<K, V> next() {
                    int i = ++index;
                    return new MapEntry<>(keys.get(i),values.get(i));
                }
                public void remove(){
                    keys.remove(index);
                    values.remove(index--);
                }
            };
        }
    }
}

public class Ex16 {

    public static void main(String[] args) {
        Maps.test(new SlowMap2<>());
    }
}
