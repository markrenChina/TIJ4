package ex25;

interface A {
    default void a(){
        System.out.println("A");
    }
}

interface B {
    default void b(){
        System.out.println("B");
    }
}

class Instance implements A,B {}


public class Ex25 {
    public static <T extends  A> void foo(T obj ){
        obj.a();
    }
    public static <T extends  B> void bar(T obj ){
        obj.b();
    }

    public static void main(String[] args) {
        Instance instance  = new Instance();
        foo(instance);
        bar(instance);
    }
}
