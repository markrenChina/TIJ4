package ex23and24;

public class Ex23 {

    public static void main(String[] args) {
        FailingConstructor fc = null;
        while (fc == null){
            try {
                fc = new FailingConstructor();
            }catch (Exception e){
                System.out.println("constructor fail " + e);
                fc = null;
            }
        }
        System.out.println("constructor success");
        fc.dispose();
    }
}
