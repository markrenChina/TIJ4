package ex4;

public class Ex4 extends Exception{

    final String error;

    public Ex4(String msg) {
        this.error = msg;
    }

    public static void main(String[] args) {
        try {
            throw new Ex4("throw Ex1 Exception");
        }catch (Ex4 e){
            System.err.println(e.error());
        }
    }

    public String error() {
        return error;
    }
}
