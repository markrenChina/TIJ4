import java.io.*;


//引入available() ,available 用于串口通信是否会产生脏数据？？？？
public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("TestEOF.java")
                )
        );
        while (in.available() != 0) {
            System.out.print((char) in.readByte());
        }
    }
}
