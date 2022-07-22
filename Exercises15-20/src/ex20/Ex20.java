package ex20;

interface I {
    void foo();
    void bar();
}

class Impl implements I {
    @Override
    public void foo() {
        System.out.println("foo");
    }

    @Override
    public void bar() {
        System.out.println("bar");
    }

    void other(){
        System.out.println("other");
    }
}

public class Ex20 {
    public static <T extends I> void  test (T obj) {
        obj.bar();
        obj.foo();
    }

    public static void main(String[] args) {
        test(new Impl());
    }
}
