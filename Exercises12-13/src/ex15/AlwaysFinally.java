package ex15;

class FourException extends Exception{ }

public class AlwaysFinally {
    public static void main(String[] args) {
        System.out.println("Entering first try block");
        try {
            System.out.println("Entering second try block");
            try {
                //throw new FourException();
                throw new RuntimeException();
            }finally {
                System.out.println("finally in 2nd try block");
            }
        }catch (RuntimeException e){
            System.out.println("Caught FourException in 1st try block");
        } finally {
            System.out.println("finally in 1st try block");
        }
    }
}
