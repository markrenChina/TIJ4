package ex33;
/*
 * Verify that FixedSizeStack in GenericCast.java generates exceptions
 * if you try to go out of its bounds. Does this mean that bounds-checking
 * code is not required?
 */

import java.util.ArrayList;

class FixedSizeStack<T> {
    private ArrayList<T> storage;
    public FixedSizeStack() {
        storage = new ArrayList<>();
    }
    public int getSize() { return storage.size(); }
    public void push(T item) { storage.add(item); }
    @SuppressWarnings("unchecked")
    public T pop() { return storage.remove(storage.size()-1);}
}

public class Ex33 {
    public static void main(String[] args) {
        FixedSizeStack<String> strings =
                new FixedSizeStack<String>();
        for(String s : "A B C D E F G H I J".split(" ")){
            strings.push(s);
        }
        strings.push("oops");
        int size = strings.getSize();
        for(int i = 0; i < size; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }

}
