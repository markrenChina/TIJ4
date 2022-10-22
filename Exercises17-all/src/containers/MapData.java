package containers;

import net.mindview.util.Generator;
import net.mindview.util.Pair;

import java.util.LinkedHashMap;

public class MapData<K,V> extends LinkedHashMap<K,V> {
    //A single Pair Generator
    public MapData(Generator<Pair<K,V>> gen, int initialCapacity) {
        for (int i = 0; i < initialCapacity; i++) {
            Pair<K,V> p = gen.next();
            put(p.key,p.value);
        }
    }

    //Two separate Generators
    public MapData(Generator<K> genK,Generator<V> genV,int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(),genV.next());
        }
    }

    //A key Generator and a single value
    public MapData(Generator<K> genK,V value,int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(),value);
        }
    }

    //An Iterable and a value Generator
    public MapData(Iterable<K> genK,Generator<V> genV){
        for (K k : genK) {
            put(k, genV.next());
        }
    }

    //An Iterable and a single value
    public MapData(Iterable<K> genK,V value){
        for (K k : genK) {
            put(k,value);
        }
    }

    //Generic convenience methods
    public static <K,V> MapData<K,V> of(
            Generator<K> genK,Generator<V> genV,int quantity){
        return new MapData<>(genK,genV,quantity);
    }

    public static <K,V> MapData<K,V> of(
            Generator<Pair<K,V>> gen,int quantity
    ){
        return new MapData<>(gen,quantity);
    }

    public static <K,V> MapData<K,V> of(
            Generator<K> genK,V value,int quantity
    ){
        return new MapData<>(genK,value,quantity);
    }

    public static <K,V> MapData<K,V> of(
            Iterable<K> genK,Generator<V> genV
    ){
        return new MapData<>(genK,genV);
    }

    public static <K,V> MapData<K,V> of(
            Iterable<K> genK, V value
    ){
        return new MapData<>(genK,value);
    }
}
