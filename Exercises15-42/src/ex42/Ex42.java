package ex42;

interface To<T,R> { void to(T src,R target); }

class A {
    private Integer n;

    public A(Integer n) {
        this.n = n;
    }

    public A inc(){
        n++;
        return this;
    }

    public A mins(){
        n--;
        return this;
    }

    public Integer getN() {
        return n;
    }
}

class B {
    private Integer n;

    public B(Integer n) {
        this.n = n;
    }

    public B inc(){
        n++;
        return this;
    }

    public B mins(){
        n--;
        return this;
    }

    public Integer getN() {
        return n;
    }
}

class Functional {
    public static <T,R> T to(T src, R target,To<T,R> to) {
        to.to(src,target);
        return src;
    }

    static class A2B implements To<A,B> {
        @Override
        public void to(A src, B target) {
            while (src.getN() != target.getN()){
                if (src.getN() < target.getN()){
                    src.inc();
                }else {
                    src.mins();
                }
            }
        }
    }
}

public class Ex42 {

    public static void main(String[] args) {
        A a = new A(11);
        B b = new B(22);
        B b2 = new B(0);
        A res = Functional.to(a,b, new Functional.A2B());
        System.out.println(res.getN());
        A res2 = Functional.to(a,b2, new Functional.A2B());
        System.out.println(res2.getN());
    }
}
