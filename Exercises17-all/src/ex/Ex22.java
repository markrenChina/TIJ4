package ex;

import containers.SimpleHashMap;

import java.util.Map;

class SimpleHashMap4<K, V> extends SimpleHashMap<K, V> {

    @Override
    public void clear() {
        for (var list : buckets) {
            if (list != null){
                list.clear();
            }
        }
    }

    @Override
    public V remove(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        V value = null;
        Map.Entry<K, V> obj = null;
        if (buckets[index] != null) {
            for (var pair : buckets[index]) {
                if (pair.getKey().equals(key)) {
                    value = pair.getValue();
                    obj = pair;
                    break;
                }
            }
            buckets[index].remove(obj);
        }
        return value;
    }

}


public class Ex22 {

    public static void main(String[] args) {
        SimpleHashMap4<Integer,String> map4 = new SimpleHashMap4<>();
        map4.put(1,"M");
        map4.put(2,"a");
        System.out.println(map4);
        map4.clear();
        System.out.println(map4);
        map4.put(3,"r");
        map4.put(4,"k");
        System.out.println(map4);
        map4.remove(3);
        System.out.println(map4);
    }
}
