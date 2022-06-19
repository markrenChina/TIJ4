package ex10;

public class Ex10 {

    public static void g() throws Exception1 {
        System.out.println("originating the exception in f()");
        throw new Exception1("thrown from f()");
    }

    public static void f() throws Exception2 {
        try {
            g();
        } catch (Exception1 e){
            System.out.println("Inside g(), e.printStackTrace()");
            Exception2 e2 = new Exception2();
            e2.initCause(e);
            throw e2;
        }
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (Exception2 e) {
            e.printStackTrace(System.err);
        }
    }
}
