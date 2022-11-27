package ex;

import containers.MapEntry;
import containers.SimpleHashMap;

import java.util.LinkedList;
import java.util.ListIterator;

class SimpleHashMap3<K,V> extends SimpleHashMap<K,V> {
    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null){
            buckets[index] = new LinkedList<>();
        }
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<K,V>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        int count = 0;
        while (it.hasNext()){
            MapEntry<K,V> iPair = it.next();
            count++;
            if (iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                it.set(pair); //Replace old with new
                found = true;
                break;
            }
        }
        if (!found){
            buckets[index].add(pair);
        }else{
            System.out.println("经过"+count+"次发现冲突，new Value =" + value );
        }
        return oldValue;
    }
}

public class Ex21 {

    public static void main(String[] args) {
        SimpleHashMap4<Integer,String> hashMap3 = new SimpleHashMap4<>();
        hashMap3.put(1,"H");
        hashMap3.put(1 + 997,"e");
        hashMap3.put(2,"l");
        hashMap3.put(3,"l");
        hashMap3.put(1 + 997,"o");
    }
}
