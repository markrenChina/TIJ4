package ex8;

class Exception{
    void foo()
 //           throws NullPointerException
    {
        throw new NullPointerException();
    }
}

public class Ex8 {

    public static void main(String[] args) {
        Exception exception = new Exception();
        exception.foo();
    }
}
