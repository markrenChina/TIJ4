package ex20;

import java.util.Scanner;

public class Ex20 {
    int i;
    long l;
    float f;
    double d;
    String s;

    public Ex20(String input) {
        Scanner scanner = new Scanner(input);
        this.i = scanner.nextInt();
        this.l = scanner.nextLong();
        this.f = scanner.nextFloat();
        this.d = scanner.nextDouble();
        this.s = scanner.next();
        if (scanner.ioException()!= null) scanner.ioException().printStackTrace();
    }

    public static void main(String[] args) {
        Ex20 ex20 = new Ex20("1 2 3 4 5 6 7 8 9 10");
        System.out.println(ex20);
    }

    @Override
    public String toString() {
        return "Ex20{" +
                "i=" + i +
                ", l=" + l +
                ", f=" + f +
                ", d=" + d +
                ", s='" + s + '\'' +
                '}';
    }
}
