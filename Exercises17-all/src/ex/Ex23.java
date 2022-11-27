package ex;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

class SimpleHashMap5<K,V> extends SimpleHashMap4<K,V> {

    @Override
    public Object getOrDefault(Object key, Object defaultValue) {
        var tmp = get(key);
        return tmp == null ? defaultValue : tmp;
    }

    @Override
    public void forEach(BiConsumer action) {
        super.forEach(action);
        //entrySet().forEach(pair -> action.accept(pair.getKey(),pair.getValue()));
    }

    @Override
    public void replaceAll(BiFunction function) {
        super.replaceAll(function);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        return super.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return super.remove(key, value);
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return super.replace(key, oldValue, newValue);
    }

    @Override
    public V replace(K key, V value) {
        return super.replace(key, value);
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return super.computeIfAbsent(key, mappingFunction);
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return super.computeIfPresent(key, remappingFunction);
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return super.compute(key, remappingFunction);
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return super.merge(key, value, remappingFunction);
    }
}


public class Ex23 {

    public static void main(String[] args) {
        SimpleHashMap5<Integer,String> hashMap5 = new SimpleHashMap5();
        hashMap5.put(1,"C");
        hashMap5.put(2,"h");
        hashMap5.put(3,"i");
        hashMap5.put(4,"n");
        hashMap5.put(5,"a");
        hashMap5.forEach((key,value) -> {
            System.out.println(key +" : " + value);
        });
    }
}
