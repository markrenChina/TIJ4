package generics;

public class NotSelfBounded<T> {
    T element;

    public T get() {
        return element;
    }

    public void set(T element) {
        this.element = element;
    }
}


class A2 extends NotSelfBounded<A2> {}
class B2 extends NotSelfBounded<A2> {}

class C2 extends NotSelfBounded<C2> {
    C2 setAndGet(C2 arg) { set(arg);return get(); }
}

class D2 {}
//Now this is Ok
class E2 extends NotSelfBounded<D2> {}
