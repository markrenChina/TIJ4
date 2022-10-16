package arrays;

public class ArrayOfGenericType<T> {

    T[] array; //OK

    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size){
        //! array = new T[size]; //Illegal
        array = (T[]) new Object[size]; //"Uncheck" warning
    }

    //Illegal
    //public <U> U[] makeArray() { return new U[10]; }
}
