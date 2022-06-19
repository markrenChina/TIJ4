package ex13;

import java.util.Random;

public class Ex13 {
    static void fun() throws Exception1 ,NullPointerException{
        int rand = new Random().nextInt(3);
        switch (rand){
            case 1: throw new Exception1();
            default: throw new NullPointerException();
        }
    }

    public static void main(String[] args) {
        try {
            fun();
        }catch (Exception e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }finally {
            System.out.println("finally");
        }
    }
}
