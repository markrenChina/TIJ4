package generics;

public class ArrayNotWork {

    static <T> T create(){
        return (T) new Integer(1);
    }

    static <T> T[] fill(T[] a){
        a[0] = create();
        return a;
    }

    public static void main(String[] args) {
        int[] intArray = new int[10];
        intArray[0] = create();
        System.out.println(intArray[0]);
//        fill(intArray); //This won't compile
    }
}
