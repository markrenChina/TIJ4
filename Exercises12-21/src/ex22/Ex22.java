package ex22;

public class Ex22 {

    public static void main(String[] args) {
        FailingConstructor fc = null;
        while (fc == null){
            try {
                fc = new FailingConstructor();
            }catch (Exception e){
                System.out.println("constructor fail");
                fc = null;
            }
        }
        System.out.println("constructor success");

    }
}
