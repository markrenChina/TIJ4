package ex27;

public class Ex27 {

    public static void main(String[] args) {
        int[] foo = new int[0];
        try {
            int i = foo[1];
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
