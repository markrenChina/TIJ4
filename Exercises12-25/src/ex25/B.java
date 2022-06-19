package ex25;

public class B extends A{
    @Override
    public void foo() throws ExceptionSecond {
        throw new ExceptionSecond();
    }
}
