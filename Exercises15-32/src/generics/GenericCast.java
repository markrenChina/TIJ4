package generics;

class FixedSizeStack<T>{
    private int index = 0;
    private Object[] storage;

    public FixedSizeStack(int size) {
        storage = new Object[size];
    }

    public void push(T item) { storage[index++] = item; }
    @SuppressWarnings("unchecked")
    //由于擦除的原因，编译器无法知道这个转型是否安全的
    public T pop() { return (T)storage[--index]; }
}

public class GenericCast {
    public static final int SIZE = 10;

    public static void main(String[] args) {
        FixedSizeStack<String> strings = new FixedSizeStack<>(SIZE);
        for (String s : "A B C D E F G H I J".split(" ")) {
            strings.push(s);
        }
        for (int i = 0; i < SIZE; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }
}
