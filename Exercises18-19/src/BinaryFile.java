import java.io.*;

/**
 * 二进制读取
 */
public class BinaryFile {

    public static byte[] read(File bFile) {
        try (BufferedInputStream bf = new BufferedInputStream(
                new FileInputStream(bFile))) {
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] read(String bFile) {
        return read(new File(bFile).getAbsoluteFile());
    }
}
