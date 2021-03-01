package ex12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String value;
        StringBuilder sb = new StringBuilder();
        while ((value = reader.readLine()) != null) {
            sb.append(value).append("\n");
        }
        reader.close();
        return sb.toString();
    }
}
