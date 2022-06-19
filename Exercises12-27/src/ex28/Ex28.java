package ex28;

public class Ex28 extends RuntimeException{

    final String error;

    public Ex28(String msg) {
        this.error = msg;
    }

    public static void main(String[] args) {
        throw new Ex28("throw Ex1 Exception");
    }

    public String error() {
        return error;
    }
}
