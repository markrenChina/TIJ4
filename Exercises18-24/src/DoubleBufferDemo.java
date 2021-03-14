import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;

public class DoubleBufferDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        //create view buffer
        DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
        //store an array of int
        doubleBuffer.put(new double[]{ 11, 42, 47, 99, 143, 811, 1016});
        //Absolute location read and write
        System.out.println(doubleBuffer.get(3));
        doubleBuffer.put(3,1811);
        //Setting a new limit before rewinding the buffer
        doubleBuffer.flip();
        while (doubleBuffer.hasRemaining()) {
            double i = doubleBuffer.get();
            System.out.print(i +", ");
        }
    }
}
