package generics;

class Manipulator<T> {
    private T obj;
    public Manipulator(T x){ obj = x; }
    //Error: cannot find symbol : method f();
    //public void manipulate() { obj.f(); }
}

class Manipulator2<T extends HasF> {
    private T obj;
    public Manipulator2(T x){ obj = x; }
    //Error: cannot find symbol : method f();
    public void manipulate() { obj.f(); }
}

public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator2<HasF> manipulator =
                new Manipulator2<>(hf);
        manipulator.manipulate();
    }
}