import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception{
        //write a file
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        //ByteBuffer has other put fun
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();
        //Add to the end of the file:
        fc = new  RandomAccessFile("data.txt","rw").getChannel();
        //change position
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
        //Read the file
        fc = new FileInputStream("data.txt").getChannel();
        //read only.we must use allocate()
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        //after read() must do flip()
        buff.flip();
        while (buff.hasRemaining())
            System.out.print((char) buff.get());
    }
}
