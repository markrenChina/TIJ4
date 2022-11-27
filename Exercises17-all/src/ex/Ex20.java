package ex;

import containers.SimpleHashMap;

class SimpleHashMap2<K,V> extends SimpleHashMap<K,V> {
    @Override
    public V put(K key, V value) {
        var oldValue = super.put(key, value);
        if (oldValue != null){
            System.out.println("key = " + key+ " 's oldValue = " + oldValue
                    + " set new Value "+ value);
        }
        return oldValue;
    }
}

public class Ex20 {

    public static void main(String[] args) {
        SimpleHashMap2<Integer,String> hashMap2 = new SimpleHashMap2<>();
        hashMap2.put(1,"H");
        hashMap2.put(1,"e");
        hashMap2.put(1,"l");
        hashMap2.put(1,"l");
        hashMap2.put(1,"o");
    }
}
