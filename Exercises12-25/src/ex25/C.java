package ex25;

public class C extends B {
    public static void main(String[] args) {
        C c = new C();
        try {
            ((A)c).foo();
        } catch (Exception e){
            System.out.println(e.getClass().getSimpleName());
        }
    }

    @Override
    public void foo() throws ExceptionThird {
        throw new ExceptionThird();
    }
}
