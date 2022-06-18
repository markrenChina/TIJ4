package ex1;

public class Ex1 extends Exception{

    public Ex1(String msg) {
        super(msg);
    }

    public static void main(String[] args) {
        try {
            throw new  Ex1("throw Ex1 Exception");
        }catch (Ex1 e){
            System.err.println(e.getMessage());
        }finally {
            System.out.println("process The End");
        }
    }
}
