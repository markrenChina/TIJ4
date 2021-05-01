import java.io.*;

public class Ex27 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        B b = new B(new A("hello")," world");
        System.out.println(b);

        System.out.println("write to file");
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("Serializable.txt")
        );

        out.writeObject(b);

        System.out.println("Read from file");
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Serializable.txt")
        );
        B inB = (B) in.readObject();
        System.out.println(inB);
    }
}

class A implements Serializable {
    String tag = "A";
    String value;

    public A(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "A{" +
                "tag='" + tag + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

class B implements Serializable{
    String tag = "B";
    String value;
    A a;

    public B(A a,String value) {
        this.a = a;
        this.value = value;
    }

    @Override
    public String toString() {
        return "B{" +
                "tag='" + tag + '\'' +
                ", value='" + value + '\'' +
                ", a=" + a +
                '}';
    }
}
