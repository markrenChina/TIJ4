package ex9;

import java.util.Random;

public class Ex9 {
    static void fun() throws Exception1, Exception2, Exception3 {
        int rand = new Random().nextInt(3);
        switch (rand){
            case 1: throw new Exception1();
            case 2: throw new Exception2();
            default: throw new Exception3();
        }
    }

    public static void main(String[] args) {
        try {
            fun();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
