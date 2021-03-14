import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.stream.Stream;

public class LargeMappedFiles {
    private static final long LENGTH = 0x8FFFFFF;//128MB

    public static void main(String[] args) throws IOException {
        MappedByteBuffer out = new RandomAccessFile("test.dat", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        Stream.iterate(0, n -> n + 1).limit(LENGTH).forEach(i -> out.put((byte) 'x'));
        System.out.println("Finished write");
        Stream.iterate(LENGTH / 2, i -> i + 1).limit(6).forEach(i -> System.out.print((char) out.get(Math.toIntExact(i))));
    }
}
