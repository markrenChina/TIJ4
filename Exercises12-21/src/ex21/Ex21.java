package ex21;

//Each disposable object must be followed by a try-finally
class NeedsCleanup {
    //Construction can't fail
    private static long counter = 1;
    private final long id = counter++;

    public NeedsCleanup() throws ConstructionException{
        throw new ConstructionException();
    }

    public void dispose() {
        System.out.println("NeedsCleanup " + id + " disposed");
    }
}

class ConstructionException extends Exception{
}

class NeedsCleanup2 extends NeedsCleanup {
    public NeedsCleanup2() throws ConstructionException {
        //super() 调用必须是构造函数主体中的第一条语句
//        try {
            super();
//        }catch (ConstructionException e){
//        }
    }
}

public class Ex21 {
    public static void main(String[] args) {
        try {
            NeedsCleanup2 nc4 = new NeedsCleanup2();
            try {
                NeedsCleanup2 nc5 = new NeedsCleanup2();
                try {
                    //...
                }finally {
                    nc5.dispose();
                }
            }catch (ConstructionException e) {
                //nc5 constructor
                System.out.println(e);
            } finally {
                nc4.dispose();
            }
        }catch (ConstructionException e) {
            //nc4 constructor
            System.out.println("nc4 " +e);
        }
    }
}