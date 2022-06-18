package exceptions;

public class MyException2 extends Exception{
    private int x;

    public MyException2() {
    }

    public MyException2(String message) {
        super(message);
    }

    public MyException2(String message, int x) {
        super(message);
        this.x = x;
    }

    public int val() { return x; }

    @Override
    public String getMessage() {
        return "Detail Message: " + x + " " +super.getMessage();
    }
}
