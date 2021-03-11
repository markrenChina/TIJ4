import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("first text ".getBytes()));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        //Doesn't work
        System.out.println("first as Char : " + buff.asCharBuffer());
        //Decode using this system's default Charset
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decode using " + encoding + ": "+ Charset.forName(encoding).decode(buff));
        //Or. We could encode with something that will print
        fc.close();
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("second text".getBytes("UTF-16BE")));
        fc.close();
        //Now try reading again
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println("second as Char : " + buff.asCharBuffer());
        //Use a CharBuffer to write through
        fc = new FileOutputStream("data2.txt").getChannel();
        buff = ByteBuffer.allocate(24); //more than needed
        buff.asCharBuffer().put("third text");
        fc.write(buff);
        fc.close();
        //Read and display
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println("Third as Char : " + buff.asCharBuffer());
    }
}
