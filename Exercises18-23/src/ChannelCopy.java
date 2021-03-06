import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        while (in.read(byteBuffer) != -1) {
            byteBuffer.flip(); //Prepare for writing
            out.write(byteBuffer);
            byteBuffer.clear(); //Prepare for reading
        }
    }
}
