package ex28;

import ex28.pets.Cat;
import ex28.pets.Pet;

class Generic1 <T> {
    T t;
    void setT(T t){
        this.t = t;
    }
}

class Generic2 <T> {
    T t;

    public Generic2(T t) {
        this.t = t;
    }

    T getT(){
        return t;
    }
}

public class Ex28 {

    //逆变可写
    static <T> void foo(Generic1<? super T> g,T t){
        g.setT(t);
    }

    //协变可读
    static <T> T bar(Generic2<? extends T> g){
        return g.getT();
    }

    public static void main(String[] args) {
        Cat cat = new Cat("mark");
        foo(new Generic1<Pet>(),cat);
        System.out.println(bar(new Generic2<Pet>(cat)));
    }
}
