package ex3;

public class Ex3 {

    public static void main(String[] args) {
        int[] foo = new int[0];
        try {
            int i = foo[1];
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
