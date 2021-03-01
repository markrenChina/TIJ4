import java.io.IOException;
import java.io.RandomAccessFile;

public class Ex16 {

    static void println(String str){
        System.out.println(str);
    }

    static void print(String str){
        System.out.print(str);
    }
    static String file = "r16test.dat";
    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        byte[] bIn = new byte[3];
        rf.read(bIn);
        for(int i = 0; i < bIn.length; i++)
            print(bIn[i] + " ");
        println("");
        // Read next 4 bytes as int:
        println("rf.readInt() = " + rf.readInt());
        println("rf.read() = " + rf.read());
        println("rf.readBoolean() = " + rf.readBoolean());
        println("rf.readByte() = " + rf.readByte());
        println("rf.read() = " + rf.read()); // ASCII h = 104
        println("rf.read() = " + rf.read()); // ASCII i = 105
        println("rf.readChar() = " + rf.readChar());
        println("rf.readChar() = " + rf.readChar());
        println("rf.readChar() = " + rf.readChar());
        println("rf.readDouble() = " + rf.readDouble());
        println("rf.readFloat() = " + rf.readFloat());
        println("rf.readInt() = " + rf.readInt());
        println("rf.readLong() = " + rf.readLong());
        println("rf.readShort() = " + rf.readShort());
        println("rf.readUTF() = " + rf.readUTF());
        rf.close();
    }
    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        byte[] ba = {0,1,2,3};
        // Store first 3 bytes of byte[] ba:
        rf.write(ba,0,3);
        // Store all 4 bytes in byte[] ba:
        rf.write(ba);
        rf.write((int)255); // Stores the lower 8 bits of int
        rf.writeBoolean(true);
        rf.writeByte((int)1000000);
        rf.writeBytes((String)"hi");
        rf.writeChar(120);
        rf.writeChars("hi");
        rf.writeDouble(3.14159);
        rf.writeFloat(2.1f);
        rf.writeInt(1057);
        rf.writeLong(123456789L);
        rf.writeShort(123);
        rf.writeUTF("Nice piece of work");
        display();
    }
}
