package ex9;

public class GenericMethods {

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("",1,2F);
        gm.f(1,"",'c');
        gm.f(gm,1F,0x2);
    }

    public <A,B,C> void f(A a,B b,C c) {
        System.out.print(a.getClass().getName()+ " ");
        System.out.print(b.getClass().getName()+ " ");
        System.out.print(c.getClass().getName());
        System.out.println();
    }
}
