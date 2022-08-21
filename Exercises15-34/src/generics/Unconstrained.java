package generics;

class Other {}
class BasicOther extends BasicHolder<Other> {}

public class Unconstrained {
    public static void main(String[] args) {
        BasicOther b = new BasicOther(),b2 = new BasicOther();
        b.setElement(new Other());
        Other other = b.getElement();
        System.out.println(b);
    }
}
