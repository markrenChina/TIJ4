package ex10;

public class GenericMethods {

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("",1,1);
        gm.f(1,"",2);
        gm.f(gm,1F,3);
    }

    public <A,B> void f(A a,B b,int c) {
        System.out.print(a.getClass().getName()+ " ");
        System.out.print(b.getClass().getName()+ " " + c);
        System.out.println();
    }
}
