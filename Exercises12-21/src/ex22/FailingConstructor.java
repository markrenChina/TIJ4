package ex22;

import java.util.concurrent.ThreadLocalRandom;

public class FailingConstructor {

    public FailingConstructor() {
        if (ThreadLocalRandom.current().nextBoolean()){
            throw new RuntimeException("construct Exception");
        }
    }
}
