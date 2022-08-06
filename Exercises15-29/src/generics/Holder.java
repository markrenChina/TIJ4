package generics;

public class Holder<T> {
    private T value;

    public Holder() {
    }

    public Holder(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.get();
        apple.set(d);
        //Holder<Fruit> fruit = apple;  //Cannot upcast
        Holder<? extends Fruit> fruit = apple;  //Ok
        Fruit p = fruit.get();
        d = (Apple) fruit.get(); //Return 'Object'
        try {
            Orange c = (Orange) fruit.get(); //No Warning
        }catch (Exception e){
            System.out.println(e);
        }
        //fruit.setValue(new Apple());//Cannot call set()
        //fruit.setValue(new Fruit());//Cannot call set()
        System.out.println(fruit.equals(d)); //OK
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        return value.equals(o);
    }
}
