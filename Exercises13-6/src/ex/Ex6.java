package ex;

public class Ex6 {

    static String toString(int v){
        return String.format("%s",v);
    }

    static String toString(long v){
        return String.format("%s",v);
    }

    static String toString(float v){
        return String.format("%s",v);
    }

    static String toString(double v){
        return String.format("%s",v);
    }

    public static void main(String[] args) {
        int i = 100;
        long l = 100L;
        float f = 100F;
        double d = 100.0;
        System.out.println(toString(i));
        System.out.println(toString(l));
        System.out.println(toString(f));
        System.out.println(toString(d));
    }
}
