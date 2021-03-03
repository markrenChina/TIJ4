import net.mindview.util.Directory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex19 {

    public static void main(String[] args) throws IOException {
        for (File file : Directory.walk(".", ".*\\.class").files) {
            byte[] ba = BinaryFile.read(file);
            for (int i = 0; i < 4; i++)
                System.out.print(Integer.toHexString(ba[i] & 0xff).toUpperCase());
            System.out.println();
        }
    }
}
