import enumerated.Enums;

import java.util.stream.IntStream;

enum Activity {
    SITTING, LYING, STANDING,HOPPING,RUNNING, DODGING,JUMPING,FALLING,FLYING
}

public class RandomTest {
    public static void main(String[] args) {
        IntStream.range(0,20).forEach( i ->
                System.out.print(Enums.random(Activity.class)+ " ")
        );
    }
}
