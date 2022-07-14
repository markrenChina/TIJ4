package ex2;

class Holder<T> {
    private T first;
    private T second;
    private T third;

    public Holder(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T get(int index) {
        if (index == 0 ){
            return first;
        }else if (index == 1){
            return second;
        }else {
            return third;
        }
    }

    public void set(int index,T value){
        if (index == 0 ){
            first = value;
        }else if (index == 1){
            second = value;
        }else {
            third = value;
        }
    }
}

public class Ex2 {

    public static void main(String[] args) {
        Holder<Integer> holder = new Holder<>(1,2,3);
        System.out.println(holder.get(1));
        holder.set(1,4);
        System.out.println(holder.get(1));
    }
}
