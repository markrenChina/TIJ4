import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Worm implements Serializable {

    private static Random rand = new Random(47);

    private Data[] d = {
            new Data(rand.nextInt()),
            new Data(rand.nextInt()),
            new Data(rand.nextInt())
    };
    private Worm next;
    private char c;

    public Worm(int i,char c) {
        System.out.println("Worm constructor: " + i);
        this.c = c;
        if (--i > 0){
            next = new Worm(i,(char)(c + 1));
        }
    }

    public Worm() {
        System.out.println("Default constructor");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Worm worm = new Worm(6,'a');
        System.out.println(worm);
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("Worm.out")
        );
        out.writeObject("Worm storage\n");
        out.writeObject(worm);
        out.close();
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("worm.out")
        );
        String s = (String) in.readObject();
        Worm w2 = (Worm) in.readObject();
        System.out.println(s + "w2 = "+ w2);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm storage\n");
        out2.writeObject(worm);
        out2.flush();
        ObjectInputStream in2 = new ObjectInputStream(
                new ByteArrayInputStream(bout.toByteArray())
        );
        s = (String) in2.readObject();
        Worm w3 = (Worm) in2.readObject();
        System.out.println(s + "w3" + w3);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(":");
        sb.append("Worm{" + "d=").append(Arrays.toString(d)).append(", next=").append(next).append(", c=").append(c).append('}');
        if (next != null) sb.append(next);
        return sb.toString();
    }
}
