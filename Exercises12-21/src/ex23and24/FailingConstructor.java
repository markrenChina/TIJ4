package ex23and24;

import java.util.concurrent.ThreadLocalRandom;

class CanFailObject {
    private static long counter = 1;
    private final long id = counter++;
    public CanFailObject() throws RuntimeException {
        if (ThreadLocalRandom.current().nextBoolean()){
            throw new RuntimeException("construct Exception");
        }
    }

    public void dispose() {
        System.out.println("NeedsCleanup " + id + " disposed");
    }
}

public class FailingConstructor {

    private final CanFailObject obj1;
    private final CanFailObject obj2;

    public FailingConstructor() {
        try {
            obj1 = new CanFailObject();
            try {
                obj2 = new CanFailObject();
            }catch (RuntimeException e){
                obj1.dispose();
                throw new RuntimeException(e);
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    public void dispose(){
        obj1.dispose();
        obj2.dispose();
    }
}
