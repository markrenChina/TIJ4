package generics;

public class GenericArray <T>{
    private T[] array;
    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        //不能声明new T[sz]
        array = (T[]) new Object[sz];
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai =
                new GenericArray<>(10);
        //This causes a ClassCaseException
        //虽然rep返回的是T[] 但是在运行时Object[]
        //! Integer[] ia = gai.rep()
        //This is OK
        Object[] oa = gai.rep();
    }

    public void put(int index,T item) {
        array[index] = item;
    }

    public T get(int index) { return array[index]; }

    //Method that exposes the underlying representation;
    public T[] rep() { return array; }
}
