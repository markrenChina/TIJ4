package ex;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Ex24 {

    public static void main(String[] args) {
        ABC[] abcs1 = new ABC[10];
        Random random = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            abcs1[i] = new ABC(random.nextInt());
        }
        Arrays.sort(abcs1, new Comparator<ABC>() {
            @Override
            public int compare(ABC o1, ABC o2) {
                return o1.equals(o2) ? 0 : (o1.values > o2.values ? 1 : -1) ;
            }
        });
        System.out.println(Arrays.toString(abcs1));
    }

    static class ABC {
        final int values;

        public ABC(int values) {
            this.values = values;
        }

        @Override
        public boolean equals(Object obj) {
            return (obj instanceof ABC) && (values == ((ABC) obj).values);
        }

        @Override
        public String toString() {
            return " " + values;
        }
    }
}
