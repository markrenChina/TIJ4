package ex;


import java.util.Arrays;

class ABC {
    final int values;

    public ABC(int values) {
        this.values = values;
    }

//    @Override
//    public boolean equals(Object obj) {
//        return (obj instanceof ABC) &&( values == ((ABC) obj).values );
//    }
}


public class Ex19 {

    public static void main(String[] args) {
        ABC[] abcs1 = new ABC[10];
        for (int i = 0; i < 10; i++) {
            abcs1[i] = new ABC(i);
        }
        ABC[] abcs2 = new ABC[10];
        for (int i = 0; i < 10; i++) {
            abcs2[i] = new ABC(i);
        }
        System.out.println(Arrays.equals(abcs1,abcs2));
    }
}
