package generics;

import coffee.Coffee;
import coffee.Latte;
import coffee.Mocha;
import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

interface Addable<T> { void add(T t); }

public class Fill2 {
    //Classtoken version
    public static <T> void fill(Addable<T> addable,
                                Class<? extends T> classToken, int size){
        for (int i = 0; i < size; i++) {
            try {
                addable.add(classToken.newInstance());
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }
    //Generator version
    public static <T> void fill(Addable<T> addable,
                                Generator<T> generator, int size){
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }
}

//To adapt a base type, you must use composition
//Make any collection Addable using composition
class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }

    @Override
    public void add(T t) {
        c.add(t);
    }
}

//A Helper to capture the type automatically
class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c){
        return new AddableCollectionAdapter<>(c);
    }
}

//To adapt a specific type,you can use inheritance
//Make a SimpleQueue Addable using inheritance
class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    public void add(T item) { super.add(item); }
}

class Fill2Test {
    public static void main(String[] args) {
        //Adapt a Collection
        List<Coffee> carrier = new ArrayList<>();
        Fill2.fill(
                new AddableCollectionAdapter<>(carrier),
                Coffee.class,3
        );
        //Helper method captures the type
        Fill2.fill(Adapter.collectionAdapter(carrier),
                Latte.class,2);
        for (Coffee coffee : carrier) {
            System.out.println(coffee);
        }
        System.out.println("-----------------");
        //Use an adapted class
        AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<>();
        Fill2.fill(coffeeQueue, Mocha.class,4);
        Fill2.fill(coffeeQueue, Latte.class,1);
        for (Coffee coffee : coffeeQueue) {
            System.out.println(coffee);
        }
    }
}