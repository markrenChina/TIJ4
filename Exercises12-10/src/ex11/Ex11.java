package ex11;

import ex10.Exception1;

public class Ex11 {

    public static void g() throws Exception1 {
        System.out.println("originating the exception in f()");
        throw new Exception1("thrown from f()");
    }

    public static void f() throws RuntimeException {
        try {
            g();
        } catch (Exception1 e){
            System.out.println("Inside g(), e.printStackTrace()");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (RuntimeException e) {
            e.printStackTrace(System.err);
        }
    }
}
