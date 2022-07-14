package typeinfo.packageaccess;

import typeinfo.interfacea.A;

class C implements A {
    @Override
    public void f() {
        System.out.println("public C.f()");
    }

    public void g() {
        System.out.println("public C.g()");
    }

    void u() {
        System.out.println("package V.u()");
    }

    protected void v() {
        System.out.println("protected C.v()");
    }

    private void w() {
        System.out.println("private C.w()");
    }
}

/**
 * 即使返回的是C类型，在包的外部仍旧不能使用A之外的方法，因为你能在包的外部命名C
 */
public class HiddenC {
    public static A makeA() { return new C(); }
}
