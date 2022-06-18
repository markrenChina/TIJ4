package ex5;

import java.util.Random;

public class Ex5 extends Exception {

    final String error;

    public Ex5(String msg) {
        this.error = msg;
    }

    public static void main(String[] args) {
        while (new Random().nextInt(5) > 2) {
            try {
                throw new Ex5("throw Ex1 Exception");
            } catch (Ex5 e) {
                //ignore
            }
        }
    }

    public String error() {
        return error;
    }
}
