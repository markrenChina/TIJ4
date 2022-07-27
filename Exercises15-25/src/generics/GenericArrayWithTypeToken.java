package generics;

import java.lang.reflect.Array;

public class GenericArrayWithTypeToken<T> {
    private T[] array;
    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        //类型标记Class<T>被传递到构造器中，以便从擦除中恢复，
        // 使得我们可以创建需要的实际类型的数组。
        array =(T[]) Array.newInstance(type,sz);
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai =
                new GenericArrayWithTypeToken<>(Integer.class,10);
        //This now works
        Integer[] ia = gai.rep();
    }

    public void put(int index,T item){
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    //Expose the underlying representation:
    public T[] rep() { return array; }
}
