import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.stream.Stream;

public class UsingRandomAccessFile {

    static String file = "rtest.dat";
    static void dispaly() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file,"r");
        for (int index=0 ; index < 7 ; index++){
            System.out.println("Value" + index +":"+ rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file,"rw");
        for (int index=0 ; index < 7 ; index++){
            rf.writeDouble(index*1.414D);
        }
        rf.writeUTF("End");
        rf.close();
        dispaly();
        rf = new RandomAccessFile(file,"rw");
        //因为double是8字节，所以5*8，查找第5个。
        rf.seek(5*8);
        rf.writeDouble(17.0001D);
        rf.close();
        dispaly();
    }
}
