package ex23;

interface FactoryI<T> {
    T create(Object arg);
}

class Foo2<T>{
    private T x;
    public <F extends FactoryI<T>> Foo2(F factory,Object i){
        x = factory.create(i);
    }


}

class IntegerFactory implements FactoryI<Integer> {
    @Override
    public Integer create(Object arg) {
        return (Integer) arg;
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget> {
        @Override
        public Widget create(Object arg) {
            return new Widget();
        }
    }
}

public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory(),1);
        new Foo2<>(new Widget.Factory(),2);
    }
}
